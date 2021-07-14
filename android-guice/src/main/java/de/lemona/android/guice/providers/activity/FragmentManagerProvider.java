package de.lemona.android.guice.providers.activity;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.Activity;
import android.app.FragmentManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class FragmentManagerProvider
implements Provider<FragmentManager> {

    private final Activity activity;

    @Inject
    private FragmentManagerProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public FragmentManager get() {
        return activity.getFragmentManager();
    }
}
