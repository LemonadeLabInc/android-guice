package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.net.wifi.WifiManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class WifiManagerProvider extends AbstractServiceProvider<WifiManager> {

    @Inject
    public WifiManagerProvider(Context context) {
        super(Context.WIFI_SERVICE, WifiManager.class, context);
    }

}
