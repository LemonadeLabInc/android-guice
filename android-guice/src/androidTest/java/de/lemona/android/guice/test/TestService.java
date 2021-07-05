package de.lemona.android.guice.test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class TestService extends Service {

    private final Binder binder = new Binder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

}
