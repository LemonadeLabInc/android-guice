package de.lemona.android.guice.providers.activity;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.app.Activity;
import android.media.session.MediaController;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class MediaControllerProvider
implements Provider<MediaController> {

    private final Activity activity;

    @Inject
    private MediaControllerProvider(Activity activity) {
        this.activity = activity;
    }

    @Override
    public MediaController get() {
        return activity.getMediaController();
    }
}
