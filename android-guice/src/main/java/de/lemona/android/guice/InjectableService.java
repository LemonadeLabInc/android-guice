package de.lemona.android.guice;

import android.app.Service;

import com.google.inject.Binder;
import com.google.inject.Module;

public abstract class InjectableService extends Service {

    static { Injection.init(); }

    protected InjectableService() {
        // I do love protected constructors for abstract classes :-)
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Injection.createInjector(this, this::onInject);
    }

    public void onInject(@SuppressWarnings("unused") Binder binder) {
        // Allow classes to override this method
    }
}
