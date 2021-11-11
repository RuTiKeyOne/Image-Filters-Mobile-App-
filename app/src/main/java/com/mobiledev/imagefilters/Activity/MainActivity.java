package com.mobiledev.imagefilters.Activity;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import com.mobiledev.imagefilters.Activity.Base.BaseActivity;
import com.mobiledev.imagefilters.R;
import com.mobiledev.imagefilters.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mainBinding;
    private final int REQUEST_CODE_PICK_IMAGE = 1;
    public static final String KEY_IMAGE_URI = "imageUri";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponentsView();
        setButtonsListener();
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

    private void initializationComponentsView(){
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void setButtonsListener(){
        setEditNewImageListener();
    }

    private void setEditNewImageListener(){
        mainBinding.editNewImageBtn.setOnClickListener(v -> {
            getImage();
        });
    }

    private void getImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE_PICK_IMAGE);
    }

}