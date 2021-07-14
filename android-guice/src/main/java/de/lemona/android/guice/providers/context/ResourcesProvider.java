package de.lemona.android.guice.providers.context;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.content.Context;
import android.content.res.Resources;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ResourcesProvider
implements Provider<Resources> {

    private final Context context;

    @Inject
    private ResourcesProvider(Context context) {
        this.context = context;
    }

    @Override
    public Resources get() {
        return context.getResources();
    }
}
