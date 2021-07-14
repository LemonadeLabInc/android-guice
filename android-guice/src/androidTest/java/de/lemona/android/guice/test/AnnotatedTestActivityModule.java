package de.lemona.android.guice.test;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

public class AnnotatedTestActivityModule implements Module {

    public static final String KEY1 = "annotatedActivityKey1";
    public static final String KEY2 = "annotatedActivityKey2";

    public static final String VALUE1 = "annotatedActivityValue1";
    public static final String VALUE2 = "annotatedActivityValue2";

    @Override
    public void configure(Binder binder) {
        binder.bindConstant().annotatedWith(Names.named(KEY1)).to(VALUE1);
        binder.bindConstant().annotatedWith(Names.named(KEY2)).to(VALUE2);
        binder.bind(AnnotatedTestActivityComponent.class);
    }
}
