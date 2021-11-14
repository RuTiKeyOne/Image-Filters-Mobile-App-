package com.mobiledev.imagefilters.Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;

import android.view.View;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.mobiledev.imagefilters.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EditImageActivityTest {

    @Rule
    public ActivityTestRule<EditImageActivity> editTestRule = new ActivityTestRule<>(EditImageActivity.class);

    @Test
    public void initializationComponentsTest() {
        editTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                editTestRule.getActivity().initializationComponents();
                assertNotNull(editTestRule.getActivity().editViewModel);
                assertNotNull(editTestRule.getActivity().photoFilters);
                assertNotNull(editTestRule.getActivity().filterViewAdapter);
                assertNotNull(editTestRule.getActivity().fileSaveHelper);
            }
        });
    }

    @Test
    public void initializationViewComponents(){
        editTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                editTestRule.getActivity().initializationComponentsView();
                assertNotNull(editTestRule.getActivity().editBinding);
                assertNotNull(editTestRule.getActivity().editBinding.filtersRecycleView.getAdapter());
                assertNotNull(editTestRule.getActivity().photoEditor);
            }
        });
    }

    @Test
    public void checkEditHeaderLayoutIsDisplayed(){
        onView(ViewMatchers.withId(R.id.editHeaderLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void checkImagePreviewIsDisplayed(){
        onView(ViewMatchers.withId(R.id.imagePreview)).check(matches(isDisplayed()));
    }

    @Test
    public void checkFiltersRecycleViewIsDisplayed(){
        onView(ViewMatchers.withId(R.id.filtersRecycleView)).check(matches(isDisplayed()));
    }

    @Test
    public void checkLayoutFooterIsDisplayed(){
        onView(ViewMatchers.withId(R.id.layoutFooter)).check(matches(isDisplayed()));
    }

    @Test
    public void checkImageBackIsDisplayed(){
        onView(ViewMatchers.withId(R.id.imageBack)).check(matches(isDisplayed()));
    }

    @Test
    public void checkFilterNameAppIsDisplayed(){
        onView(ViewMatchers.withId(R.id.filterNameApp)).check(matches(isDisplayed()));
    }

    @Test
    public void checkImageSaveIsDisplayed(){
        onView(ViewMatchers.withId(R.id.imageSave)).check(matches(isDisplayed()));
    }

    @Test
    public void checkImageBackIsClickable(){
        onView(ViewMatchers.withId(R.id.imageBack)).check(matches(isClickable()));
    }

    @Test
    public void checkImageSaveIsClickable(){
        onView(ViewMatchers.withId(R.id.imageSave)).check(matches(isClickable()));
    }

}