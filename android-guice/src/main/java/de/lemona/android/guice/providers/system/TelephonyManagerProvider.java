package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.telephony.TelephonyManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class TelephonyManagerProvider extends AbstractServiceProvider<TelephonyManager> {

    @Inject
    public TelephonyManagerProvider(Context context) {
        super(Context.TELEPHONY_SERVICE, TelephonyManager.class, context);
    }

}
