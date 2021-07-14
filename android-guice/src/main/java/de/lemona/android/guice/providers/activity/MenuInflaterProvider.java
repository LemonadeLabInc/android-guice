package de.lemona.android.guice.providers.activity;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.Activity;
import android.view.MenuInflater;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class MenuInflaterProvider
implements Provider<MenuInflater> {

    private final Activity activity;

    @Inject
    private MenuInflaterProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public MenuInflater get() {
        return activity.getMenuInflater();
    }
}
