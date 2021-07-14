package de.lemona.android.guice.test;

import android.R;
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

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import org.junit.Assert;

import de.lemona.android.guice.Id;
import de.lemona.android.guice.Ids;
import de.lemona.android.guice.InjectableActivity;
import de.lemona.android.guice.Nullable;

public class TestInjectableActivity extends InjectableActivity {

    @Override
    protected void onInject(Binder binder) {
        binder.install(new TestModule());
        final String yes = this.getString(R.string.yes);
        binder.bind(String.class).annotatedWith(Ids.id(R.string.yes)).toInstance(yes);
    }

    @Inject
    private Activity activity;
    @Inject
    private Application application;
    @Inject
    @Nullable
    private ActionBar actionBar;
    @Inject
    private ComponentName componentName;
    @Inject
    private FragmentManager fragmentManager;
    @Inject
    private LoaderManager loaderManager;
    @Inject
    @Nullable
    private MediaController mediaController;
    @Inject
    private MenuInflater menuInflater;
    @Inject
    private TransitionManager transitionManager;
    @Inject
    private Window window;

    // Inject here for tests of @Id, this will be in the injector, so normally
    // used by other classes needing those kinds of resources/views/...
    @Inject
    @Id(R.string.yes)
    private String yes;

    String testValue;

    @Inject
    private void setValue(@Named(TestModule.KEY) String testValue) {
        // Concatenate (and fail) on multiple calls
        if (this.testValue == null) this.testValue = testValue;
        else this.testValue = this.testValue + testValue;
    }

    public void validate() {

        Assert.assertNotNull("Null named test value", this.testValue);

        Assert.assertNotNull("Null Activity instance", this.activity);
        Assert.assertNotNull("Null Application instance", this.application);
//      Assert.assertNotNull("Null ActionBar instance",         this.actionBar);
        Assert.assertNotNull("Null ComponentName instance", this.componentName);
        Assert.assertNotNull("Null FragmentManager instance", this.fragmentManager);
        Assert.assertNotNull("Null LoaderManager instance", this.loaderManager);
//      Assert.assertNotNull("Null MediaController instance",   this.mediaController);
        Assert.assertNotNull("Null MenuInflater instance", this.menuInflater);
        Assert.assertNotNull("Null TransitionManager instance", this.transitionManager);
        Assert.assertNotNull("Null Window instance", this.window);

        Assert.assertNotNull("Null resource instance", this.yes);

        Assert.assertSame("Invalid named test value", TestModule.VALUE, this.testValue);

        Assert.assertSame("Invalid Activity instance", this, this.activity);
        Assert.assertSame("Invalid Application instance", this.getApplication(), this.application);
        Assert.assertSame("Invalid ActionBar instance", this.getActionBar(), this.actionBar);
        Assert.assertSame("Invalid ComponentName instance", this.getComponentName(), this.componentName);
        Assert.assertSame("Invalid FragmentManager instance", this.getFragmentManager(), this.fragmentManager);
        Assert.assertSame("Invalid LoaderManager instance", this.getLoaderManager(), this.loaderManager);
        Assert.assertSame("Invalid MediaController instance", this.getMediaController(), this.mediaController);
        Assert.assertSame("Invalid MenuInflater instance", this.getMenuInflater(), this.menuInflater);
        Assert.assertSame("Invalid TransitionManager instance", this.getContentTransitionManager(), this.transitionManager);
        Assert.assertSame("Invalid Window instance", this.getWindow(), this.window);

        Assert.assertSame("Invalid resource instance", this.getString(R.string.yes), this.yes);
    }
}
