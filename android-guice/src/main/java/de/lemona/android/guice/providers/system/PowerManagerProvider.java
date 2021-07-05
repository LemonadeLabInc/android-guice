package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.os.PowerManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class PowerManagerProvider extends AbstractServiceProvider<PowerManager> {

    @Inject
    public PowerManagerProvider(Context context) {
        super(Context.POWER_SERVICE, PowerManager.class, context);
    }

}
