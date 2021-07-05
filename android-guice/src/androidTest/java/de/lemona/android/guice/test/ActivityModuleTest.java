package de.lemona.android.guice.test;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.ComponentName;
import android.media.session.MediaController;
import android.transition.TransitionManager;
import android.view.MenuInflater;
import android.view.Window;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.inject.Inject;
import com.google.inject.Injector;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.lemona.android.guice.Injection;
import de.lemona.android.guice.Nullable;

@RunWith(AndroidJUnit4.class)
public class ActivityModuleTest {

    @Rule
    public ActivityScenarioRule<TestActivity> activityRule = new ActivityScenarioRule<>(TestActivity.class);

    @Test
    public void testNotNullInjection() {
        activityRule.getScenario().onActivity(activity -> {
            Assert.assertNotNull("Null activity in test", activity);

            final Injector injector = Injection.createInjector(activity);

            Assert.assertNotNull("Null Activity instance",          injector.getInstance(Activity.class));
            Assert.assertNotNull("Null Application instance",       injector.getInstance(Application.class));
            //Assert.assertNotNull("Null ActionBar instance",         injector.getInstance(ActionBar.class));
            Assert.assertNotNull("Null ComponentName instance",     injector.getInstance(ComponentName.class));
            Assert.assertNotNull("Null FragmentManager instance",   injector.getInstance(FragmentManager.class));
            Assert.assertNotNull("Null LoaderManager instance",     injector.getInstance(LoaderManager.class));
            //Assert.assertNotNull("Null MediaController instance",   injector.getInstance(MediaController.class));
            Assert.assertNotNull("Null MenuInflater instance",      injector.getInstance(MenuInflater.class));
            Assert.assertNotNull("Null TransitionManager instance", injector.getInstance(TransitionManager.class));
            Assert.assertNotNull("Null Window instance",            injector.getInstance(Window.class));
        });
    }

    @Test
    public void testInjectionInstances() {
        activityRule.getScenario().onActivity(activity -> {
            Assert.assertNotNull("Null activity in test", activity);

            final Injector injector = Injection.createInjector(activity);

            Assert.assertSame("Invalid Activity instance",          activity,                               injector.getInstance(Activity.class));
            Assert.assertSame("Invalid Application instance",       activity.getApplication(),               injector.getInstance(Application.class));
            Assert.assertSame("Invalid ActionBar instance",         activity.getActionBar(),                injector.getInstance(ActionBar.class));
            Assert.assertSame("Invalid ComponentName instance",     activity.getComponentName(),            injector.getInstance(ComponentName.class));
            Assert.assertSame("Invalid FragmentManager instance",   activity.getFragmentManager(),          injector.getInstance(FragmentManager.class));
            Assert.assertSame("Invalid LoaderManager instance",     activity.getLoaderManager(),            injector.getInstance(LoaderManager.class));
            Assert.assertSame("Invalid MediaController instance",   activity.getMediaController(),          injector.getInstance(MediaController.class));
            Assert.assertSame("Invalid MenuInflater instance",      activity.getMenuInflater(),             injector.getInstance(MenuInflater.class));
            Assert.assertSame("Invalid TransitionManager instance", activity.getContentTransitionManager(), injector.getInstance(TransitionManager.class));
            Assert.assertSame("Invalid Window instance",            activity.getWindow(),                   injector.getInstance(Window.class));
        });
    }

    @Test
    public void testInjectee() {
        activityRule.getScenario().onActivity(activity -> {
            Assert.assertNotNull("Null activity in test", activity);

            final Injector injector = Injection.createInjector(activity);
            injector.getInstance(ActivityInjectee.class).validate(activity);
        });
    }

    @Test
    public void testInjection() {
        activityRule.getScenario().onActivity(activity -> {
            Assert.assertNotNull("Null activity in test", activity);

            Injection.createInjector(activity).getInstance(ActivityInjectee.class).validate(activity);
        });
    }

    /* ========================================================================================== */

    public static class ActivityInjectee {

        @Inject Activity                  activity;
        @Inject Application               application;
        @Inject @Nullable ActionBar       actionBar;
        @Inject ComponentName             componentName;
        @Inject FragmentManager           fragmentManager;
        @Inject LoaderManager             loaderManager;
        @Inject @Nullable MediaController mediaController;
        @Inject MenuInflater              menuInflater;
        @Inject TransitionManager         transitionManager;
        @Inject Window                    window;

        public void validate(Activity activity) {
            Assert.assertNotNull("Null Activity instance",          this.activity);
            Assert.assertNotNull("Null Application instance",       this.application);
            //Assert.assertNotNull("Null ActionBar instance",         this.actionBar);
            Assert.assertNotNull("Null ComponentName instance",     this.componentName);
            Assert.assertNotNull("Null FragmentManager instance",   this.fragmentManager);
            Assert.assertNotNull("Null LoaderManager instance",     this.loaderManager);
            //Assert.assertNotNull("Null MediaController instance",   this.mediaController);
            Assert.assertNotNull("Null MenuInflater instance",      this.menuInflater);
            Assert.assertNotNull("Null TransitionManager instance", this.transitionManager);
            Assert.assertNotNull("Null Window instance",            this.window);

            Assert.assertSame("Invalid Activity instance",          activity,                               this.activity);
            Assert.assertSame("Invalid Application instance",       activity.getApplication(),              this.application);
            Assert.assertSame("Invalid ActionBar instance",         activity.getActionBar(),                this.actionBar);
            Assert.assertSame("Invalid ComponentName instance",     activity.getComponentName(),            this.componentName);
            Assert.assertSame("Invalid FragmentManager instance",   activity.getFragmentManager(),          this.fragmentManager);
            Assert.assertSame("Invalid LoaderManager instance",     activity.getLoaderManager(),            this.loaderManager);
            Assert.assertSame("Invalid MediaController instance",   activity.getMediaController(),          this.mediaController);
            Assert.assertSame("Invalid MenuInflater instance",      activity.getMenuInflater(),             this.menuInflater);
            Assert.assertSame("Invalid TransitionManager instance", activity.getContentTransitionManager(), this.transitionManager);
            Assert.assertSame("Invalid Window instance",            activity.getWindow(),                   this.window);
        }
    }
}
