package de.lemona.android.guice;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import android.content.Context;

@ContextSingleton
class ContextInjectorProvider
implements Provider<ContextInjector> {

    private final Injector injector;
    private final Context context;

    @Inject
    private ContextInjectorProvider(Injector injector, Context context) {
        this.injector = injector;
        this.context = context;
    }

    @Override
    public ContextInjector get() {
        return new ContextInjector(injector, context);
    }
}
