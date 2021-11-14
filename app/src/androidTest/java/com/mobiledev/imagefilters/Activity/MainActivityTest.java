package com.mobiledev.imagefilters.Activity;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.assertNotNull;

import android.view.View;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.mobiledev.imagefilters.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void initializationComponentsViewTest(){
        activityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activityTestRule.getActivity().initializationComponentsView();
                assertNotNull(activityTestRule.getActivity().mainBinding);
            }
        });
    }

    @Test
    public void checkMainHeaderLayoutIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mainHeaderLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void checkAppCompatImageViewIsDisplayed(){
        onView(ViewMatchers.withId(R.id.appCompatImageView)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainLandingBackgroundIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mainLandingBackground)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainTextTitleIsDisplayed(){
        onView(ViewMatchers.withId(R.id.mainTextTitle)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMainTextSubTitle(){
        onView(ViewMatchers.withId(R.id.mainTextSubtitle)).check(matches(isDisplayed()));
    }

    @Test
    public void checkEditNewImageBtnIsDisplayed(){
        onView(ViewMatchers.withId(R.id.editNewImageBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void checkEditNewImageBtnIsClickable(){
        onView(ViewMatchers.withId(R.id.editNewImageBtn)).check(matches(isClickable()));
    }

}