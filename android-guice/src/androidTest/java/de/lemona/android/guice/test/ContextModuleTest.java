package de.lemona.android.guice.test;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.lemona.android.guice.AppContext;
import de.lemona.android.guice.Injection;


@RunWith(AndroidJUnit4.class)
public class ContextModuleTest  {

    @Test
    public void testNotNullInjection() {
        final Context context = InstrumentationRegistry.getInstrumentation().getContext();
        final Context applicationContext = context.getApplicationContext();
        Assert.assertNotNull("Null context in test", context);
        Assert.assertNotNull("Null applicationContext in test", applicationContext);
        Assert.assertNotSame("Same context/applicationContext", context, applicationContext);

        final Injector injector = Injection.createInjector(context);

        Assert.assertNotNull("Null Context instance", injector.getInstance(Context.class));
        Assert.assertNotNull("Null Context instance", injector.getInstance(Key.get(Context.class, AppContext.class)));

        Assert.assertNotNull("Null ApplicationInfo instance", injector.getInstance(ApplicationInfo.class));
        Assert.assertNotNull("Null AssetManager instance", injector.getInstance(AssetManager.class));
        Assert.assertNotNull("Null ContentResolver instance", injector.getInstance(ContentResolver.class));
        Assert.assertNotNull("Null PackageManager instance", injector.getInstance(PackageManager.class));
        Assert.assertNotNull("Null Resources instance", injector.getInstance(Resources.class));
    }

    @Test
    public void testInjectionInstances() {
        final Context context = InstrumentationRegistry.getInstrumentation().getContext();
        final Context applicationContext = context.getApplicationContext();
        Assert.assertNotNull("Null context in test", context);
        Assert.assertNotNull("Null applicationContext in test", applicationContext);
        Assert.assertNotSame("Same context/applicationContext", context, applicationContext);

        final Injector injector = Injection.createInjector(context);

        Assert.assertSame("Wrong Context instance", context, injector.getInstance(Context.class));
        Assert.assertSame("Wrong Application Context instance", context.getApplicationContext(), injector.getInstance(Key.get(Context.class, AppContext.class)));

        Assert.assertSame("Wrong ApplicationInfo instance", context.getApplicationInfo(), injector.getInstance(ApplicationInfo.class));
        Assert.assertSame("Wrong AssetManager instance", context.getAssets(), injector.getInstance(AssetManager.class));
        Assert.assertSame("Wrong ContentResolver instance", context.getContentResolver(), injector.getInstance(ContentResolver.class));
        Assert.assertSame("Wrong PackageManager instance", context.getPackageManager(), injector.getInstance(PackageManager.class));
        Assert.assertSame("Wrong Resources instance", context.getResources(), injector.getInstance(Resources.class));
    }

    @Test
    public void testInjectee() {
        final Context context = ApplicationProvider.getApplicationContext();
        Assert.assertNotNull("Null context in test", context);

        final Injector injector = Injection.createInjector(context);
        injector.getInstance(ContextInjectee.class).validate(context);
    }

    public void testInjection() {
        final Context context = ApplicationProvider.getApplicationContext();
        Assert.assertNotNull("Null context in test", context);

        Injection.createInjector(context).getInstance(ContextInjectee.class).validate(context);
    }

    /* ========================================================================================== */

    public static class ContextInjectee {

        @Inject @AppContext Context applicationContext;
        @Inject Context context;
        @Inject ApplicationInfo applicationInfo;
        @Inject AssetManager assetManager;
        @Inject ContentResolver contentResolver;
        @Inject PackageManager packageManager;
        @Inject Resources resources;

        public void validate(Context context) {

            Assert.assertNotNull("Null Context instance", this.applicationContext);
            Assert.assertNotNull("Null Context instance", this.context);

            Assert.assertNotNull("Null ApplicationInfo instance", this.applicationInfo);
            Assert.assertNotNull("Null AssetManager instance", this.assetManager);
            Assert.assertNotNull("Null ContentResolver instance", this.contentResolver);
            Assert.assertNotNull("Null PackageManager instance", this.packageManager);
            Assert.assertNotNull("Null Resources instance", this.resources);

            Assert.assertSame("Wrong Application Context instance", context.getApplicationContext(), this.applicationContext);
            Assert.assertSame("Wrong Context instance", context, this.context);

            Assert.assertSame("Wrong ApplicationInfo instance", context.getApplicationInfo(), this.applicationInfo);
            Assert.assertSame("Wrong AssetManager instance", context.getAssets(), this.assetManager);
            Assert.assertSame("Wrong ContentResolver instance", context.getContentResolver(), this.contentResolver);
            Assert.assertSame("Wrong PackageManager instance", context.getPackageManager(), this.packageManager);
            Assert.assertSame("Wrong Resources instance", context.getResources(), this.resources);
        }
    }
}
