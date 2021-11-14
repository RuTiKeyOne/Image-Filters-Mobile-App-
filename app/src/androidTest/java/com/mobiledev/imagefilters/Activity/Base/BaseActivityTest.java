package com.mobiledev.imagefilters.Activity.Base;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import android.Manifest;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.mobiledev.imagefilters.Activity.EditImageActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BaseActivityTest {

    @Rule
    public ActivityTestRule<EditImageActivity> editTestRule = new ActivityTestRule<>(EditImageActivity.class);

    @Test
    public void initializationComponentsViewTest(){
        editTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((BaseActivity)editTestRule.getActivity()).initializationComponentsView();
                assertNotNull(((BaseActivity)editTestRule.getActivity()).progressDialog);
            }
        });
    }

    @Test
    public void requestPermissionTest(){
        editTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertTrue(((BaseActivity)editTestRule.getActivity()).requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE));
            }
        });
    }

    @Test
    public void showLoadingTest(){
        editTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((BaseActivity)editTestRule.getActivity()).showLoading("Some message");
                assertTrue(((BaseActivity)editTestRule.getActivity()).progressDialog.isShowing());
            }
        });
    }

}