package com.nickhe.reciperescue;

import android.support.test.rule.ActivityTestRule;
import android.widget.RelativeLayout;

import com.nickhe.reciperescue.Controllers.HomeFragment;
import com.nickhe.reciperescue.Controllers.TestActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class HomeFragmentTest {

    @Rule
    public ActivityTestRule<TestActivity> activityTestRule = new ActivityTestRule<>(TestActivity.class);

    private TestActivity testActivity = null;

    @Before
    public void setup()
    {
        testActivity = activityTestRule.getActivity();
    }

    /**
     * Test the whether the HomeFragment can be
     * launched properly.
     */
    @Test
    public void launchTest()
    {
        RelativeLayout container = testActivity.findViewById(R.id.testContainer);

        assertNotNull(container);

        HomeFragment homeFragment = new HomeFragment();

        assertNotNull(homeFragment);

        testActivity.getSupportFragmentManager().beginTransaction().add(container.getId(), new HomeFragment()).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();

    }

    @After
    public void tearDown()
    {
        testActivity = null;
        activityTestRule = null;
    }

}