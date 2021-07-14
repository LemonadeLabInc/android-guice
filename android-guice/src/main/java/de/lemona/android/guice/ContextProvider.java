package de.lemona.android.guice;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import android.content.Context;

@Singleton
class ContextProvider implements Provider<Context> {

    private final ContextScope contextScope;

    @Inject
    private ContextProvider(ContextScope contextScope) {
        this.contextScope = contextScope;
    }

    @Override
    public Context get() {
        return contextScope.currentContext();
    }

}
