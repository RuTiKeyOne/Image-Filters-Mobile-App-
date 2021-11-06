package com.mobiledev.imagefilters.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;

import com.mobiledev.imagefilters.R;
import com.mobiledev.imagefilters.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private final int REQUEST_CODE_PICK_IMAGE = 1;
    private final String KEY_IMAGE_URI = "imageUri";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponentsView();
        setButtonsListener();
    }

    private void initializationComponentsView(){
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void setButtonsListener(){
        setEditNewImageListener();
    }

    private void setEditNewImageListener(){
        mainBinding.editNewImageBtn.setOnClickListener(v -> {
            Intent piclerIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            piclerIntent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            startActivityForResult(piclerIntent, REQUEST_CODE_PICK_IMAGE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK){
            if(data != null){
                Intent editImageIntent = new Intent(getApplicationContext(), EditImageActivity.class);
                editImageIntent.putExtra(KEY_IMAGE_URI, data.getData());
                startActivity(editImageIntent);
            }
        }
    }
}