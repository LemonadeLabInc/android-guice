package de.lemona.android.guice.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ApplicationProvider implements Provider<Application> {

    private final Context context;

    @Inject
    private ApplicationProvider(Context context) {
        this.context = context;
    }

    @Override
    public Application get() {
        // Simple checks
        if (context instanceof Application) return (Application) context;
        if (context instanceof Activity) return ((Activity) context).getApplication();
        if (context instanceof Service) return ((Service) context).getApplication();

        // Normally the application context *is* the application itself...
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) return (Application) applicationContext;

        throw new ProvisionException("Application instance not available");
    }
}
