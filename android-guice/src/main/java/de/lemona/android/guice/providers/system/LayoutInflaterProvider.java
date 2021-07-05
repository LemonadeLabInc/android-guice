package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.view.LayoutInflater;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class LayoutInflaterProvider extends AbstractServiceProvider<LayoutInflater> {

    @Inject
    public LayoutInflaterProvider(Context context) {
        super(Context.LAYOUT_INFLATER_SERVICE, LayoutInflater.class, context);
    }

}
