package de.lemona.android.guice.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import junit.framework.Assert;

public class InjectableActivityTest extends ActivityUnitTestCase<TestInjectableActivity> {

    public InjectableActivityTest() {
        super(TestInjectableActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        startActivity(new Intent(getInstrumentation().getTargetContext(), TestActivity.class), null, null);
    }

    public void testInjectee() {
        final TestInjectableActivity activity = getActivity();
        Assert.assertNotNull("Null activity in test", activity);
        activity.validate();
    }

}
