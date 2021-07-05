package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.app.UiModeManager;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class UiModeManagerProvider extends AbstractServiceProvider<UiModeManager> {

    @Inject
    public UiModeManagerProvider(Context context) {
        super(Context.UI_MODE_SERVICE, UiModeManager.class, context);
    }

}
