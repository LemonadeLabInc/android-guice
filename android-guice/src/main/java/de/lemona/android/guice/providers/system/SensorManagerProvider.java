package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.hardware.SensorManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class SensorManagerProvider extends AbstractServiceProvider<SensorManager> {

    @Inject
    public SensorManagerProvider(Context context) {
        super(Context.SENSOR_SERVICE, SensorManager.class, context);
    }

}
