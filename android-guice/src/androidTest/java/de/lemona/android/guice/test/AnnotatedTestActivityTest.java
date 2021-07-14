package de.lemona.android.guice.test;

import android.util.Log;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class AnnotatedTestActivityTest {

    @Rule
    public ActivityScenarioRule<AnnotatedTestActivity> activityRule = new ActivityScenarioRule<>(AnnotatedTestActivity.class);

    @Test
    public void testInjection() {
        activityRule.getScenario().onActivity(activity -> {
            Log.i("TAG", "VALUE 1 = " + activity.value1);
            Log.i("TAG", "VALUE 2 = " + activity.value2);
            Log.i("TAG", "CONTEXT = " + activity.context);
            Log.i("TAG", "COMPONENT = " + activity.component);
            Log.i("TAG", "COMPONENT.VALUE 1 = " + activity.component.value1);
            Log.i("TAG", "COMPONENT.VALUE 2 = " + activity.component.value2);
            Log.i("TAG", "COMPONENT.CONTEXT = " + activity.component.context);
        });
    }
}
