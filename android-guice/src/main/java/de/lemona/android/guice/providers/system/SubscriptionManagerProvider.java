package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.content.Context;
import android.telephony.SubscriptionManager;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class SubscriptionManagerProvider extends AbstractServiceProvider<SubscriptionManager> {

    @Inject
    public SubscriptionManagerProvider(Context context) {
        super(Context.TELEPHONY_SUBSCRIPTION_SERVICE, SubscriptionManager.class, context);
    }

}
