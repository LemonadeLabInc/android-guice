package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.app.SearchManager;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class SearchManagerProvider extends AbstractServiceProvider<SearchManager> {

    @Inject
    public SearchManagerProvider(Context context) {
        super(Context.SEARCH_SERVICE, SearchManager.class, context);
    }

}
