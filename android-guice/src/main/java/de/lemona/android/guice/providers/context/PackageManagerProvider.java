package de.lemona.android.guice.providers.context;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.content.Context;
import android.content.pm.PackageManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class PackageManagerProvider
implements Provider<PackageManager> {

    private final Context context;

    @Inject
    private PackageManagerProvider(Context context) {
        this.context = context;
    }

    @Override
    public PackageManager get() {
        return context.getPackageManager();
    }
}
