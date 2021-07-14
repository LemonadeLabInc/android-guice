package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class InputMethodManagerProvider extends AbstractServiceProvider<InputMethodManager> {

    @Inject
    public InputMethodManagerProvider(Context context) {
        super(Context.INPUT_METHOD_SERVICE, InputMethodManager.class, context);
    }

}
