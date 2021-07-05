package de.lemona.android.guice.providers.system;

import com.google.inject.Provider;

import android.annotation.SuppressLint;
import android.content.Context;

public abstract class AbstractServiceProvider<T>
implements Provider<T> {

    private final String key;
    private final Class<T> type;
    private final Context context;

    protected AbstractServiceProvider(String key, Class<T> type, Context context) {
        this.key = key;
        this.type = type;
        this.context = context;
    }

    @Override
    public T get() {
        @SuppressLint("WrongConstant")
        Object service = context.getSystemService(key);
        return type.cast(service);
    }
}
