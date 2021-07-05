package de.lemona.android.guice.test;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import de.lemona.android.guice.InjectableService;
import junit.framework.Assert;

public class TestInjectableService extends InjectableService {

    @Inject private Service     service;
    @Inject private Application application;

    private String testValue;

    @Inject
    private void setValue(@Named(TestModule.KEY) String testValue) {
        // Concatenate (and fail) on multiple calls
        if (this.testValue == null) this.testValue = testValue;
        else this.testValue = this.testValue + testValue;
    }

    @Override
    public void onInject(Binder binder) {
        binder.install(new TestModule());
    }

    private final IBinder binder = new android.os.Binder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public void validate() {

        Assert.assertNotNull("Null named test value",     this.testValue);

        Assert.assertNotNull("Null Service instance",     this.service);
        Assert.assertNotNull("Null Application instance", this.application);

        Assert.assertSame("Invalid named test value",     TestModule.VALUE,      this.testValue);

        Assert.assertSame("Invalid Service instance",     this,                  this.service);
        Assert.assertSame("Invalid Application instance", this.getApplication(), this.application);
    }

}
