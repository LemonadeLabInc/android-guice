package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.app.KeyguardManager;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class KeyguardManagerProvider extends AbstractServiceProvider<KeyguardManager> {

    @Inject
    public KeyguardManagerProvider(Context context) {
        super(Context.KEYGUARD_SERVICE, KeyguardManager.class, context);
    }

}
