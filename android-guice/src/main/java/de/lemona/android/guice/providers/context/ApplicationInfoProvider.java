package de.lemona.android.guice.providers.context;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ApplicationInfoProvider
implements Provider<ApplicationInfo> {

    private final Context context;

    @Inject
    private ApplicationInfoProvider(Context context) {
        this.context = context;
    }

    @Override
    public ApplicationInfo get() {
        return context.getApplicationInfo();
    }
}
