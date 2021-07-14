package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.net.ConnectivityManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ConnectivityManagerProvider extends AbstractServiceProvider<ConnectivityManager> {

    @Inject
    public ConnectivityManagerProvider(Context context) {
        super(Context.CONNECTIVITY_SERVICE, ConnectivityManager.class, context);
    }

}
