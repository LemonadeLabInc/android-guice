package de.lemona.android.guice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;

import android.content.Context;

public class ContextScope implements Scope {

    private final ThreadLocal<Stack<Context>> stacks = new ThreadLocal<Stack<Context>>() {
        @Override protected Stack<Context> initialValue() {
            return new Stack<Context>();
        }
    };

    private final Map<Context, Map<Key<?>, Object>> contextInstances = new WeakHashMap<>();
    private final Context applicationContext;

    ContextScope(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    Context currentContext() {
        final Stack<Context> stack = stacks.get();
        if (stack.isEmpty()) return applicationContext;
        return stack.peek();
    }

    void pushContext(Context context) {
        if (context == null) throw new NullPointerException("Null context");
        stacks.get().push(context);
    }

    void popContext() {
        stacks.get().pop();
    }

    @Override
    public <T> Provider<T> scope(final Key<T> key, final Provider<T> unscopedProvider) {
        return new Provider<T>() {

            @Override
            public T get() {
                final Context context = currentContext();

                // Get or create our instances map
                final Map<Key<?>, Object> instances;
                synchronized(contextInstances) {
                    final Map<Key<?>, Object> existing = contextInstances.get(context);
                    if (existing != null) {
                        instances = existing;
                    } else {
                        instances = new HashMap<Key<?>, Object>();
                        contextInstances.put(context, instances);
                    }
                }

                // Get or create our instance
                synchronized (instances) {
                    if (instances.containsKey(key)) {
                        @SuppressWarnings("unchecked")
                        final T instance = (T) instances.get(key);
                        return instance;
                    }

                    final T instance = unscopedProvider.get();
                    instances.put(key, instance);
                    return instance;
                }
            }
        };
    }
}
