package de.lemona.android.guice;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.ProvisionException;
import com.google.inject.internal.util.$FinalizableReferenceQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static com.google.inject.Stage.PRODUCTION;

public final class Injection {

    private static final String TAG = Injection.class.getPackage().getName();

    private Injection() {
        throw new IllegalStateException("Do not construct");
    }

    /* ========================================================================================== */

    // Filter annoying log for which we can do nothing about...
    private static boolean initialized = false;
    static final void init() {
        if (initialized) return;
        initialized = true;

        Logger.getLogger($FinalizableReferenceQueue.class.getName()).setFilter(new Filter() {
            @Override public boolean isLoggable(LogRecord record) {
                if (record.getMessage().startsWith("Could not load Finalizer")) return false;
                return true;
            }
        });
    }

    static { Injection.init(); }

    /* ========================================================================================== */

    public static ContextInjector createInjector(Context context) {
        return createInjector(context, (Iterable<Module>) null);
    }

    public static ContextInjector createInjector(Context context, Module... modules) {
        if ((modules == null) || (modules.length == 0)) return createInjector(context, (Iterable<Module>) null);
        return createInjector(context, Arrays.asList(modules));
    }

    public static ContextInjector createInjector(Context context, Iterable<? extends Module> modules) {

        if (modules == null) modules = Collections.emptySet();
        final Injector applicationInjector = applicationInjector(context);
        final ContextScope scope = applicationInjector.getInstance(ContextScope.class);

        scope.pushContext(context);
        try {
            Log.d(TAG, "Creating context injector for \"" + context.getClass().getName() + "\"");
            final Injector injector = applicationInjector.createChildInjector(modules);
            injector.injectMembers(context);
            return new ContextInjector(injector, context);
        } finally {
            scope.popContext();
        }
    }

    /* ========================================================================================== */

    private static final Map<Context, Injector> applicationInjectors = new IdentityHashMap<>();

    private static final int FLAGS = PackageManager.GET_ACTIVITIES
                                   | PackageManager.GET_INSTRUMENTATION
                                   | PackageManager.GET_PROVIDERS
                                   | PackageManager.GET_RECEIVERS
                                   | PackageManager.GET_SERVICES;

    public static Injector applicationInjector(Context childContext, Module...additionalMod) {

        final Context applicationContext = childContext.getApplicationContext();
        final Injector existing = applicationInjectors.get(applicationContext);
        if (existing != null) return existing;

        synchronized (applicationInjectors) {
            final Injector previous = applicationInjectors.get(applicationContext);
            if (previous != null) return existing;

            final String packageName = applicationContext.getPackageName();
            final PackageManager packageManager = applicationContext.getPackageManager();
            final PackageInfo packageInfo;

            Log.i(TAG, "Creating application injector for package \"" + packageName + "\"");

            try {
                packageInfo = packageManager.getPackageInfo(packageName, FLAGS);
            } catch (final Exception exception) {
                throw new ProvisionException("Unable to get package info for " + packageName, exception);
            }

            final Set<String> componentClasses = new HashSet<>();
            findComponents(componentClasses, packageInfo.activities);
            findComponents(componentClasses, packageInfo.instrumentation);
            findComponents(componentClasses, packageInfo.providers);
            findComponents(componentClasses, packageInfo.receivers);
            findComponents(componentClasses, packageInfo.services);

            final ClassLoader classLoader = applicationContext.getClassLoader();

            final Set<Class<? extends Module>> moduleClasses = new HashSet<>();
            for (final String className: componentClasses) {
                findModules(classLoader, className, moduleClasses);
            }

            final List<Module> modules = new ArrayList<>();
            modules.add(new AndroidModule(applicationContext));
            modules.addAll(Arrays.asList(additionalMod));

            for (final Class<? extends Module> moduleClass: moduleClasses) try {
                modules.add(moduleClass.newInstance());
            } catch (final Exception exception) {
                throw new ProvisionException("Unable to instantiate module " + moduleClass.getName(), exception);
            }

            // Create in "PRODUCTION" to early instantiate all singletons...
            final Injector injector = Guice.createInjector(PRODUCTION, modules);
            applicationInjectors.put(applicationContext, injector);
            injector.injectMembers(applicationContext);

            Log.i(TAG, "Injector for package \"" + packageName + "\" created");

            return injector;
        }
    }

    private static void findComponents(Collection<String> classNames, PackageItemInfo[] infos) {
        if (infos == null) return;
        for (final PackageItemInfo info: infos) {
            classNames.add(info.name.startsWith(".") ? info.packageName + info.name : info.name);
        }
    }

    private static void findModules(ClassLoader classLoader, String className, Collection<Class<? extends Module>> moduleClasses) {
        final Class<?> componentClass;

        try {
            componentClass = classLoader.loadClass(className);
        } catch (final ClassNotFoundException classNotFoundException) {
            Log.e(TAG, "Unable to find component class " + className + ", so ignore this one");
            return;
        } catch (final Exception exception) {
            throw new ProvisionException("Unable to load component class " + className, exception);
        }

        if (componentClass.isAnnotationPresent(AppModules.class)) {
            final AppModules annotation = componentClass.getAnnotation(AppModules.class);
            for (final Class<? extends Module> moduleClass: annotation.value()) {
                Log.i(TAG, "Application class \"" + componentClass.getName() + "\" declares module \"" + moduleClass.getName() + "\"");
                moduleClasses.add(moduleClass);
            }
        }
    }
}
