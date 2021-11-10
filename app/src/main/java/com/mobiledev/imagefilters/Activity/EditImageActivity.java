package com.mobiledev.imagefilters.Activity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.mobiledev.imagefilters.Activity.Base.BaseActivity;
import com.mobiledev.imagefilters.Adapter.FilterViewAdapter;
import com.mobiledev.imagefilters.Helper.FileSaveHelper;
import com.mobiledev.imagefilters.Interfaces.FilterListener;
import com.mobiledev.imagefilters.Model.*;
import com.mobiledev.imagefilters.R;
import com.mobiledev.imagefilters.ViewModels.EditViewModel;
import com.mobiledev.imagefilters.databinding.ActivityEditImageBinding;
import java.io.FileNotFoundException;
import java.util.*;
import ja.burhanrashid52.photoeditor.*;

public class EditImageActivity extends BaseActivity implements FilterListener {

    private ActivityEditImageBinding editBinding;
    private EditViewModel editViewModel;
    private static List<Filter> photoFilters = new ArrayList<>();
    private FilterViewAdapter filterViewAdapter;
    private PhotoEditor photoEditor;
    private FileSaveHelper saveHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponents();
        initializationComponentsView();
        setButtonsListener();
        displayImagePreviewFromTry();
    }


    private void initializationComponents() {
        editViewModel = new ViewModelProvider(this).get(EditViewModel.class);
        photoFilters = FilterData.getPhotoFilters();
        filterViewAdapter = new FilterViewAdapter(this, photoFilters);
        saveHelper = new FileSaveHelper();
    }

    private void initializationComponentsView() {
        editBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit_image);
        editBinding.setIsLoading(true);
        editBinding.filtersRecycleView.setAdapter(filterViewAdapter);
        photoEditor = new PhotoEditor.Builder(this, editBinding.imagePreview).build();
        photoEditor.setFilterEffect(PhotoFilter.NONE);
    }

    private void setButtonsListener() {
        setBackListener();
        setSaveListener();
    }

    private void setBackListener() {
        editBinding.imageBack.setOnClickListener(v -> onBackPressed());
    }

    private void setSaveListener() {
        editBinding.imageSave.setOnClickListener(v -> saveImage());
    }

    private void displayImagePreviewFromTry() {
        try {
            displayImagePreview();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void displayImagePreview() throws FileNotFoundException {
        Uri imageUri = getIntent().getParcelableExtra(MainActivity.KEY_IMAGE_URI);
        if (imageUri != null) {
            Bitmap imageBitmap = editViewModel.prepareImageView(imageUri);
            editBinding.setIsLoading(false);
            editBinding.imagePreview.getSource().setImageBitmap(imageBitmap);
            editBinding.imagePreview.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFilterSelected(PhotoFilter photoFilter) {
        photoEditor.setFilterEffect(photoFilter);
    }

    private void saveImage() {
        final String fileName = System.currentTimeMillis() + ".png";
        if (isHasStoragePermissionOrIsSdkHigherThan28()) {
            showLoading(getString(R.string.saving));

        }
    }


}