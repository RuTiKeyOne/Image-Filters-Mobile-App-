package com.mobiledev.imagefilters.Adapter;

import static org.junit.Assert.*;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.mobiledev.imagefilters.Activity.EditImageActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FilterViewAdapterTest {
    @Rule
    public ActivityTestRule<EditImageActivity> editTestRule = new ActivityTestRule<>(EditImageActivity.class);
    private FilterViewAdapter filterViewAdapter;

    @Before
    public void setUp(){
        filterViewAdapter = editTestRule.getActivity().getFilterViewAdapter();
    }

    @Test
    public void initializationComponentsTest(){
        filterViewAdapter = new FilterViewAdapter(editTestRule.getActivity(), editTestRule.getActivity().getPhotoFilters());
        assertNotNull(filterViewAdapter.filterListener);
        assertNotNull(filterViewAdapter.filters);
    }

    @Test
    public void getItemCountTest(){
        assertTrue(filterViewAdapter.getItemCount() > 0);
    }
}