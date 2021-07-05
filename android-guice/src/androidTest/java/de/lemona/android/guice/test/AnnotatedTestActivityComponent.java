package de.lemona.android.guice.test;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import android.content.Context;

@Singleton // Run when creating the injector...
public class AnnotatedTestActivityComponent {

    @Inject @Named(AnnotatedTestActivityModule.KEY1) String value1;
    @Inject @Named(AnnotatedTestActivityModule.KEY2) String value2;
    @Inject Context context;

    @Inject
    private AnnotatedTestActivityComponent() {
        // Let Guice do its job...
    }

}
