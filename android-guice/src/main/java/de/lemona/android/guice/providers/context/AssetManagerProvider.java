package de.lemona.android.guice.providers.context;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.content.Context;
import android.content.res.AssetManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class AssetManagerProvider
implements Provider<AssetManager> {

    private final Context context;

    @Inject
    private AssetManagerProvider(Context context) {
        this.context = context;
    }

    @Override
    public AssetManager get() {
        return context.getAssets();
    }
}
