package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.media.MediaRouter;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class MediaRouterProvider extends AbstractServiceProvider<MediaRouter> {

    @Inject
    public MediaRouterProvider(Context context) {
        super(Context.MEDIA_ROUTER_SERVICE, MediaRouter.class, context);
    }

}
