package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.view.WindowManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class WindowManagerProvider extends AbstractServiceProvider<WindowManager> {

    @Inject
    public WindowManagerProvider(Context context) {
        super(Context.WINDOW_SERVICE, WindowManager.class, context);
    }

}
