package de.lemona.android.guice.providers.activity;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.Activity;
import android.content.ComponentName;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ComponentNameProvider
implements Provider<ComponentName> {

    private final Activity activity;

    @Inject
    private ComponentNameProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ComponentName get() {
        return activity.getComponentName();
    }
}
