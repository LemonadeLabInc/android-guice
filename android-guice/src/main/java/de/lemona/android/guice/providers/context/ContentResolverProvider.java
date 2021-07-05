package de.lemona.android.guice.providers.context;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.content.ContentResolver;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class ContentResolverProvider
implements Provider<ContentResolver> {

    private final Context context;

    @Inject
    private ContentResolverProvider(Context context) {
        this.context = context;
    }

    @Override
    public ContentResolver get() {
        return context.getContentResolver();
    }
}
