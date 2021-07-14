package de.lemona.android.guice.providers.activity;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.ActionBar;
import android.app.Activity;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ActionBarProvider
implements Provider<ActionBar> {

    private final Activity activity;

    @Inject
    private ActionBarProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ActionBar get() {
        return activity.getActionBar();
    }
}
