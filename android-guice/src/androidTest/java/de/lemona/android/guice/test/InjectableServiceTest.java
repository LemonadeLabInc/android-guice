package de.lemona.android.guice.test;

import android.content.Intent;
import android.os.IBinder;

import androidx.test.rule.ServiceTestRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeoutException;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

public class InjectableServiceTest {

    @Rule
    public ServiceTestRule serviceServiceTestRule = new ServiceTestRule();

    @Test
    public void testInjectee() throws TimeoutException {
        Intent testIntent = new Intent(getApplicationContext(), TestInjectableService.class);
        IBinder iBinder = serviceServiceTestRule.bindService(testIntent);
        final TestInjectableService service = (TestInjectableService) ((TestInjectableService.LocalBinder) iBinder).getService();
        Assert.assertNotNull("Null Service in test", service);
        service.validate();
    }

}
