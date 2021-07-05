package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.os.BatteryManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class BatteryManagerProvider extends AbstractServiceProvider<BatteryManager> {

    @Inject
    public BatteryManagerProvider(Context context) {
        super(Context.BATTERY_SERVICE, BatteryManager.class, context);
    }

}
