package de.lemona.android.guice.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;

import android.app.Activity;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ActivityProvider
implements Provider<Activity> {

    private final Context context;

    @Inject
    private ActivityProvider(Context context) {
        this.context = context;
    }

    @Override
    public Activity get() {
        if (context instanceof Activity) return (Activity) context;
        throw new ProvisionException("Current context is not an activity: " + context);
    }
}
