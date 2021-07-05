package de.lemona.android.guice;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Scope;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeConverterBinding;

import android.content.Context;

public class ContextInjector implements Injector {

    private final ContextScope scope;
    private final Injector injector;
    private final Context context;

    ContextInjector(Injector injector, Context context) {
        this.scope = injector.getInstance(ContextScope.class);
        this.injector = injector;
        this.context = context;
    }

    public Injector getGuiceInjector() {
        return injector;
    }

    @Override
    public void injectMembers(Object instance) {
        scope.pushContext(context);
        try {
            injector.injectMembers(instance);
        } finally {
            scope.popContext();
        }
    }

    @Override
    public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral) {
        return new ContextMembersInjector<T>(injector.getMembersInjector(typeLiteral));
    }

    @Override
    public <T> MembersInjector<T> getMembersInjector(Class<T> type) {
        return new ContextMembersInjector<T>(injector.getMembersInjector(type));
    }

    @Override
    public <T> Provider<T> getProvider(Key<T> key) {
        return new ContextProvider<T>(injector.getProvider(key));
    }

    @Override
    public <T> Provider<T> getProvider(Class<T> type) {
        return new ContextProvider<T>(injector.getProvider(type));
    }

    @Override
    public <T> T getInstance(Key<T> key) {
        scope.pushContext(context);
        try {
            return injector.getInstance(key);
        } finally {
            scope.popContext();
        }
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        scope.pushContext(context);
        try {
            return injector.getInstance(type);
        } finally {
            scope.popContext();
        }
    }

    @Override
    public ContextInjector getParent() {
        return new ContextInjector(injector.getParent(), context);
    }

    @Override
    public Injector createChildInjector(Iterable<? extends Module> modules) {
        return new ContextInjector(injector.createChildInjector(modules), context);
    }

    @Override
    public Injector createChildInjector(Module... modules) {
        return new ContextInjector(injector.createChildInjector(modules), context);
    }

    /* ====================================================================== */

    @Override
    public Map<Key<?>, Binding<?>> getBindings() {
        throw new UnsupportedOperationException("Use getGuiceInjector(...)");
    }

    @Override
    public Map<Key<?>, Binding<?>> getAllBindings() {
        throw new UnsupportedOperationException("Use getGuiceInjector(...)");
    }

    @Override
    public <T> Binding<T> getBinding(Key<T> key) {
        throw new UnsupportedOperationException("Use getGuiceInjector(...)");
    }

    @Override
    public <T> Binding<T> getBinding(Class<T> type) {
        throw new UnsupportedOperationException("Use getGuiceInjector(...)");
    }

    @Override
    public <T> Binding<T> getExistingBinding(Key<T> key) {
        throw new UnsupportedOperationException("Use getGuiceInjector(...)");
    }

    @Override
    public <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> type) {
        throw new UnsupportedOperationException("Use getGuiceInjector(...)");
    }

    @Override
    public Map<Class<? extends Annotation>, Scope> getScopeBindings() {
        throw new UnsupportedOperationException("Use getGuiceInjector(...)");
    }

    @Override
    public Set<TypeConverterBinding> getTypeConverterBindings() {
        throw new UnsupportedOperationException("Use getGuiceInjector(...)");
    }

    /* ====================================================================== */

    private class ContextMembersInjector<T> implements MembersInjector<T> {

        private final MembersInjector<T> membersInjector;

        private ContextMembersInjector(MembersInjector<T> membersInjector) {
            this.membersInjector = membersInjector;
        }

        @Override
        public void injectMembers(T instance) {
            scope.pushContext(context);
            try {
                membersInjector.injectMembers(instance);
            } finally {
                scope.popContext();
            }
        }
    }

    /* ====================================================================== */

    private class ContextProvider<T> implements Provider<T> {

        private final Provider<T> provider;

        private ContextProvider(Provider<T> provider) {
            this.provider = provider;
        }

        @Override
        public T get() {
            scope.pushContext(context);
            try {
                return provider.get();
            } finally {
                scope.popContext();
            }
        }
    }
}
