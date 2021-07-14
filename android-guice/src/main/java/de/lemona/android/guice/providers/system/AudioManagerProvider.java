package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.media.AudioManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class AudioManagerProvider extends AbstractServiceProvider<AudioManager> {

    @Inject
    public AudioManagerProvider(Context context) {
        super(Context.AUDIO_SERVICE, AudioManager.class, context);
    }

}
