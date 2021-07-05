package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.app.AlarmManager;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class AlarmManagerProvider extends AbstractServiceProvider<AlarmManager> {

    @Inject
    public AlarmManagerProvider(Context context) {
        super(Context.ALARM_SERVICE, AlarmManager.class, context);
    }

}
