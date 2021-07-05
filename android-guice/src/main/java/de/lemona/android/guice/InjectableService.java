package de.lemona.android.guice;

import com.google.inject.Binder;
import com.google.inject.Module;

import android.app.Service;

public abstract class InjectableService extends Service {

    static { Injection.init(); }

    protected InjectableService() {
        // I do love protected constructors for abstract classes :-)
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Injection.createInjector(this, new Module() {
            @Override public void configure(Binder binder) {
                onInject(binder);
            }
        });
    }

    public void onInject(@SuppressWarnings("unused") Binder binder) {
        // Allow classes to override this method
    }
}
