package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.location.LocationManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class LocationManagerProvider extends AbstractServiceProvider<LocationManager> {

    @Inject
    public LocationManagerProvider(Context context) {
        super(Context.LOCATION_SERVICE, LocationManager.class, context);
    }

}
