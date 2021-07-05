package de.lemona.android.guice.test;

import android.content.Intent;
import android.test.ServiceTestCase;
import junit.framework.Assert;

public class InjectableServiceTest extends ServiceTestCase<TestInjectableService> {

    public InjectableServiceTest() {
        super(TestInjectableService.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.bindService(new Intent(getSystemContext(), TestService.class));
    }

    public void testInjectee() {
        final TestInjectableService service = getService();
        Assert.assertNotNull("Null Service in test", service);
        service.validate();
    }

}
