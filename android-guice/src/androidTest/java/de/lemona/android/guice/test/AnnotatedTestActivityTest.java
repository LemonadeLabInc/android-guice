package de.lemona.android.guice.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.util.Log;

public class AnnotatedTestActivityTest extends ActivityUnitTestCase<AnnotatedTestActivity> {

    public AnnotatedTestActivityTest() {
        super(AnnotatedTestActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        startActivity(new Intent(getInstrumentation().getTargetContext(), TestActivity.class), null, null);
    }

    public void testInjection() {
        final AnnotatedTestActivity activity = this.getActivity();
        Log.i("TAG", "VALUE 1 = " + activity.value1);
        Log.i("TAG", "VALUE 2 = " + activity.value2);
        Log.i("TAG", "CONTEXT = " + activity.context);
        Log.i("TAG", "COMPONENT = " + activity.component);
        Log.i("TAG", "COMPONENT.VALUE 1 = " + activity.component.value1);
        Log.i("TAG", "COMPONENT.VALUE 2 = " + activity.component.value2);
        Log.i("TAG", "COMPONENT.CONTEXT = " + activity.component.context);
    }
}
