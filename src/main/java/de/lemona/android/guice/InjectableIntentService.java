package de.lemona.android.guice;

import android.app.IntentService;

import com.google.inject.Binder;
import com.google.inject.Module;

public abstract class InjectableIntentService extends IntentService {

    static { Injection.init(); }

    /**
     * {@inheritDoc}
     */
    protected InjectableIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Injection.createInjector(this, new Module() {
            @Override
            public void configure(Binder binder) {
                onInject(binder);
            }
        });
    }

    protected void onInject(@SuppressWarnings("unused") Binder binder) {
        // Allow classes to override this method
    }
}
