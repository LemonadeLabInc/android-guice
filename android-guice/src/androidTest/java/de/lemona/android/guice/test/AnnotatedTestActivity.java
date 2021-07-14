package de.lemona.android.guice.test;

import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.lemona.android.guice.AppModules;
import de.lemona.android.guice.InjectableActivity;

@AppModules(AnnotatedTestActivityModule.class)
public class AnnotatedTestActivity extends InjectableActivity {

    @Inject @Named(AnnotatedTestActivityModule.KEY1) String value1;
    @Inject @Named(AnnotatedTestActivityModule.KEY2) String value2;
    @Inject AnnotatedTestActivityComponent component;
    @Inject Context context;

}
