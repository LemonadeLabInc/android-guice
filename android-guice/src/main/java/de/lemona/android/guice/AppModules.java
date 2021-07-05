package de.lemona.android.guice;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.Module;

@Target({TYPE})
@Retention(RUNTIME)
public @interface AppModules {

    public Class<? extends Module>[] value() default {};

}
