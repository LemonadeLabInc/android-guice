package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.os.storage.StorageManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class StorageManagerProvider extends AbstractServiceProvider<StorageManager> {

    @Inject
    public StorageManagerProvider(Context context) {
        super(Context.STORAGE_SERVICE, StorageManager.class, context);
    }

}
