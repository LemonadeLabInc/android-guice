package de.lemona.android.guice.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class InjectableActivityTest {

    @Rule
    public ActivityScenarioRule<TestInjectableActivity> activityScenarioRule = new ActivityScenarioRule<>(TestInjectableActivity.class);

    @Test
    public void testInjectee() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            Assert.assertNotNull("Null activity in test", activity);
            activity.validate();
        });
    }

}
