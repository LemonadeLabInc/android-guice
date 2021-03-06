package de.lemona.android.guice;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.ScopeAnnotation;

@ScopeAnnotation
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface ContextSingleton {
    // Empty annotation
}
