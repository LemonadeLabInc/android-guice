package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.app.NotificationManager;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class NotificationManagerProvider extends AbstractServiceProvider<NotificationManager> {

    @Inject
    public NotificationManagerProvider(Context context) {
        super(Context.NOTIFICATION_SERVICE, NotificationManager.class, context);
    }

}
