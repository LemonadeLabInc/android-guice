package de.lemona.android.guice.test;

import android.app.Application;
import android.app.Service;
import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ServiceTestRule;

import com.google.inject.Inject;
import com.google.inject.Injector;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import de.lemona.android.guice.Injection;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

@RunWith(AndroidJUnit4.class)
public class ServiceModuleTest {

    @Rule
    public ServiceTestRule serviceTestRule = new ServiceTestRule();

    private Service getService() throws TimeoutException {
        Intent testIntent = new Intent(getApplicationContext(), TestService.class);
        TestService.LocalBinder localBinder = (TestService.LocalBinder) serviceTestRule.bindService(testIntent);
        return localBinder.getService();
    }

    @Test
    public void testNotNullInjection() throws TimeoutException {
        final Service service = getService();
        Assert.assertNotNull("Null service in test", service);

        final Injector injector = Injection.createInjector(service);

        Assert.assertNotNull("Null service instance", injector.getInstance(Service.class));
        Assert.assertNotNull("Null Application instance", injector.getInstance(Application.class));
    }

    @Test
    public void testInjectionInstances() throws TimeoutException {
        final Service service = getService();
        Assert.assertNotNull("Null Service in test", service);

        final Injector injector = Injection.createInjector(service);

        Assert.assertSame("Invalid Service instance", service, injector.getInstance(Service.class));
        Assert.assertSame("Invalid Application instance", service.getApplication(), injector.getInstance(Application.class));
    }

    @Test
    public void testInjectee() throws TimeoutException {
        final Service service = getService();
        Assert.assertNotNull("Null Service in test", service);

        final Injector injector = Injection.createInjector(service);
        injector.getInstance(ServiceInjectee.class).validate(service);
    }

    @Test
    public void testInjection() throws TimeoutException {
        final Service service = getService();
        Assert.assertNotNull("Null Service in test", service);

        Injection.createInjector(service).getInstance(ServiceInjectee.class).validate(service);
    }

    /* ========================================================================================== */

    public static class ServiceInjectee {

        @Inject
        Service service;
        @Inject
        Application application;

        public void validate(Service service) {
            Assert.assertNotNull("Null Service instance", this.service);
            Assert.assertNotNull("Null Application instance", this.application);

            Assert.assertSame("Invalid Service instance", service, this.service);
            Assert.assertSame("Invalid Application instance", service.getApplication(), this.application);
        }
    }
}
