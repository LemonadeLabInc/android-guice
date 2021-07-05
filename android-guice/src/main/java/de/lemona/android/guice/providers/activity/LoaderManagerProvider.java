package de.lemona.android.guice.providers.activity;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.Activity;
import android.app.LoaderManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class LoaderManagerProvider
implements Provider<LoaderManager> {

    private final Activity activity;

    @Inject
    private LoaderManagerProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public LoaderManager get() {
        return activity.getLoaderManager();
    }
}
