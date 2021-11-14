package com.mobiledev.imagefilters.Repository;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.mobiledev.imagefilters.Activity.EditImageActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EditImageRepositoryImpTest {

    @Rule
    public ActivityTestRule<EditImageActivity> editTestRule = new ActivityTestRule<>(EditImageActivity.class);
    private EditImageRepositoryImp editImageRepositoryImp;

    @Test
    public void EditImageRepositoryImpConstructor(){
        editTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                editImageRepositoryImp = new EditImageRepositoryImp(editTestRule.getActivity().getApplicationContext());
                assertNotNull(editImageRepositoryImp.context);
            }
        });
    }

}