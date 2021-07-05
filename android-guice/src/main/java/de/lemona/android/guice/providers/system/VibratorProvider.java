package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.os.Vibrator;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class VibratorProvider extends AbstractServiceProvider<Vibrator> {

    @Inject
    public VibratorProvider(Context context) {
        super(Context.VIBRATOR_SERVICE, Vibrator.class, context);
    }

}
