package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.app.ActivityManager;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ActivityManagerProvider extends AbstractServiceProvider<ActivityManager> {

    @Inject
    public ActivityManagerProvider(Context context) {
        super(Context.ACTIVITY_SERVICE, ActivityManager.class, context);
    }

}
