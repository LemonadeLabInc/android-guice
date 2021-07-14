package de.lemona.android.guice.test;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

public class TestModule implements Module {

    public static final String KEY = "the test key";
    public static final String VALUE = "the test value";

    @Override
    public void configure(Binder binder) {
        binder.bindConstant().annotatedWith(Names.named(KEY)).to(VALUE);
    }

}
