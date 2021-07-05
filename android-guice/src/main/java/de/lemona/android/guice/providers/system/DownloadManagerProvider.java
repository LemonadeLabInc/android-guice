package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.app.DownloadManager;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class DownloadManagerProvider extends AbstractServiceProvider<DownloadManager> {

    @Inject
    public DownloadManagerProvider(Context context) {
        super(Context.DOWNLOAD_SERVICE, DownloadManager.class, context);
    }

}
