package de.lemona.android.guice;

import com.google.inject.Binder;
import com.google.inject.Module;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.session.MediaController;
import android.transition.TransitionManager;
import android.view.MenuInflater;
import android.view.Window;
import de.lemona.android.guice.providers.ActivityProvider;
import de.lemona.android.guice.providers.ApplicationProvider;
import de.lemona.android.guice.providers.ServiceProvider;
import de.lemona.android.guice.providers.activity.ActionBarProvider;
import de.lemona.android.guice.providers.activity.ComponentNameProvider;
import de.lemona.android.guice.providers.activity.FragmentManagerProvider;
import de.lemona.android.guice.providers.activity.LoaderManagerProvider;
import de.lemona.android.guice.providers.activity.MediaControllerProvider;
import de.lemona.android.guice.providers.activity.MenuInflaterProvider;
import de.lemona.android.guice.providers.activity.TransitionManagerProvider;
import de.lemona.android.guice.providers.activity.WindowProvider;
import de.lemona.android.guice.providers.context.ApplicationInfoProvider;
import de.lemona.android.guice.providers.context.AssetManagerProvider;
import de.lemona.android.guice.providers.context.ContentResolverProvider;
import de.lemona.android.guice.providers.context.PackageManagerProvider;
import de.lemona.android.guice.providers.context.ResourcesProvider;
import de.lemona.android.guice.providers.system.ActivityManagerProvider;
import de.lemona.android.guice.providers.system.AlarmManagerProvider;
import de.lemona.android.guice.providers.system.AudioManagerProvider;
import de.lemona.android.guice.providers.system.BatteryManagerProvider;
import de.lemona.android.guice.providers.system.ConnectivityManagerProvider;
import de.lemona.android.guice.providers.system.DownloadManagerProvider;
import de.lemona.android.guice.providers.system.InputMethodManagerProvider;
import de.lemona.android.guice.providers.system.JobSchedulerProvider;
import de.lemona.android.guice.providers.system.KeyguardManagerProvider;
import de.lemona.android.guice.providers.system.LayoutInflaterProvider;
import de.lemona.android.guice.providers.system.LocationManagerProvider;
import de.lemona.android.guice.providers.system.MediaRouterProvider;
import de.lemona.android.guice.providers.system.NotificationManagerProvider;
import de.lemona.android.guice.providers.system.PowerManagerProvider;
import de.lemona.android.guice.providers.system.SearchManagerProvider;
import de.lemona.android.guice.providers.system.SensorManagerProvider;
import de.lemona.android.guice.providers.system.StorageManagerProvider;
import de.lemona.android.guice.providers.system.SubscriptionManagerProvider;
import de.lemona.android.guice.providers.system.TelephonyManagerProvider;
import de.lemona.android.guice.providers.system.UiModeManagerProvider;
import de.lemona.android.guice.providers.system.VibratorProvider;
import de.lemona.android.guice.providers.system.WifiManagerProvider;
import de.lemona.android.guice.providers.system.WindowManagerProvider;

public class AndroidModule implements Module {

    static {
        Injection.init();
    }

    private final Context applicationContext;
    private final ContextScope contextScope;

    public AndroidModule(Context context) {
        this.applicationContext = context.getApplicationContext();
        this.contextScope = new ContextScope(applicationContext);
    }

    @Override
    public void configure(Binder binder) {
        // Bind our scope, to tie contexts together...
        binder.bind(ContextScope.class).toInstance(contextScope);
        binder.bindScope(ContextSingleton.class, contextScope);

        binder.bind(ContextInjector.class).toProvider(ContextInjectorProvider.class).in(ContextSingleton.class);

        // Application context singleton and context provider (scoped)
        binder.bind(Context.class).annotatedWith(AppContext.class).toInstance(applicationContext);
        binder.bind(Context.class).toProvider(ContextProvider.class);

        // Basic activity, application context and service (base)
        binder.bind(Activity.class).toProvider(ActivityProvider.class);
        binder.bind(Application.class).toProvider(ApplicationProvider.class);
        binder.bind(Service.class).toProvider(ServiceProvider.class);

        // Derived from context (or subclasses thereof)

        binder.bind(ApplicationInfo.class).toProvider(ApplicationInfoProvider.class);
        binder.bind(AssetManager.class).toProvider(AssetManagerProvider.class);
        binder.bind(ContentResolver.class).toProvider(ContentResolverProvider.class);
        binder.bind(PackageManager.class).toProvider(PackageManagerProvider.class);
        binder.bind(Resources.class).toProvider(ResourcesProvider.class);

        // Derived from activity (or subclasses thereof)
        binder.bind(ActionBar.class).toProvider(ActionBarProvider.class);
        binder.bind(ComponentName.class).toProvider(ComponentNameProvider.class);
        binder.bind(FragmentManager.class).toProvider(FragmentManagerProvider.class);
        binder.bind(LoaderManager.class).toProvider(LoaderManagerProvider.class);
        binder.bind(MediaController.class).toProvider(MediaControllerProvider.class);
        binder.bind(MenuInflater.class).toProvider(MenuInflaterProvider.class);
        binder.bind(TransitionManager.class).toProvider(TransitionManagerProvider.class);
        binder.bind(Window.class).toProvider(WindowProvider.class);

        // System services
        binder.bind(android.app.ActivityManager.class).toProvider(ActivityManagerProvider.class);
        binder.bind(android.app.AlarmManager.class).toProvider(AlarmManagerProvider.class);
        binder.bind(android.app.DownloadManager.class).toProvider(DownloadManagerProvider.class);
        binder.bind(android.app.job.JobScheduler.class).toProvider(JobSchedulerProvider.class);
        binder.bind(android.app.KeyguardManager.class).toProvider(KeyguardManagerProvider.class);
        binder.bind(android.app.NotificationManager.class).toProvider(NotificationManagerProvider.class);
        binder.bind(android.app.SearchManager.class).toProvider(SearchManagerProvider.class);
        binder.bind(android.app.UiModeManager.class).toProvider(UiModeManagerProvider.class);
        binder.bind(android.hardware.SensorManager.class).toProvider(SensorManagerProvider.class);
        binder.bind(android.location.LocationManager.class).toProvider(LocationManagerProvider.class);
        binder.bind(android.media.AudioManager.class).toProvider(AudioManagerProvider.class);
        binder.bind(android.media.MediaRouter.class).toProvider(MediaRouterProvider.class);
        binder.bind(android.net.ConnectivityManager.class).toProvider(ConnectivityManagerProvider.class);
        binder.bind(android.net.wifi.WifiManager.class).toProvider(WifiManagerProvider.class);
        binder.bind(android.os.BatteryManager.class).toProvider(BatteryManagerProvider.class);
        binder.bind(android.os.PowerManager.class).toProvider(PowerManagerProvider.class);
        binder.bind(android.os.storage.StorageManager.class).toProvider(StorageManagerProvider.class);
        binder.bind(android.os.Vibrator.class).toProvider(VibratorProvider.class);
        binder.bind(android.telephony.SubscriptionManager.class).toProvider(SubscriptionManagerProvider.class);
        binder.bind(android.telephony.TelephonyManager.class).toProvider(TelephonyManagerProvider.class);
        binder.bind(android.view.inputmethod.InputMethodManager.class).toProvider(InputMethodManagerProvider.class);
        binder.bind(android.view.LayoutInflater.class).toProvider(LayoutInflaterProvider.class);
        binder.bind(android.view.WindowManager.class).toProvider(WindowManagerProvider.class);
    }
}
