package de.lemona.android.guice;

import android.app.Activity;
import android.os.Bundle;

import com.google.inject.Binder;
import com.google.inject.Module;

public abstract class InjectableActivity extends Activity {

    static { Injection.init(); }

    protected InjectableActivity() {
        // I do love protected constructors for abstract classes :-)
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injection.createInjector(this, this::onInject);
    }

    protected void onInject(@SuppressWarnings("unused") Binder binder) {
        // Allow classes to override this method
    }
}
