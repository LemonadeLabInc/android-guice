package de.lemona.android.guice.providers.activity;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.Activity;
import android.view.Window;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class WindowProvider
implements Provider<Window> {

    private final Activity activity;

    @Inject
    private WindowProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Window get() {
        return activity.getWindow();
    }
}
