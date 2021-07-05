package de.lemona.android.guice.providers.activity;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.Activity;
import android.transition.TransitionManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class TransitionManagerProvider
implements Provider<TransitionManager> {

    private final Activity activity;

    @Inject
    private TransitionManagerProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public TransitionManager get() {
        return activity.getContentTransitionManager();
    }
}
