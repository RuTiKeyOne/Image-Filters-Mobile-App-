package com.mobiledev.imagefilters.ViewModels;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.mobiledev.imagefilters.Activity.EditImageActivity;
import com.mobiledev.imagefilters.Activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EditViewModelTest {

    @Rule
    public ActivityTestRule<EditImageActivity> editTestRule = new ActivityTestRule<>(EditImageActivity.class);

    @Test
    public void EditViewModelConstructorTest(){
        assertNotNull(editTestRule.getActivity().editViewModel.editImageRepository);
    }

}