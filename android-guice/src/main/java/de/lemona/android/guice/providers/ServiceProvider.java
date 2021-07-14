package de.lemona.android.guice.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;

import android.app.Service;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ServiceProvider
implements Provider<Service> {

    private final Context context;

    @Inject
    private ServiceProvider(Context context) {
        this.context = context;
    }

    @Override
    public Service get() {
        if (context instanceof Service) return (Service) context;
        throw new ProvisionException("Current context is not a service: " + context);
    }
}
