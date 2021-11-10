package com.mobiledev.imagefilters.Activity.Base;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static com.mobiledev.imagefilters.Helper.FileSaveHelper.isSdkHigherThan28;
import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class BaseActivity extends AppCompatActivity {

    public static final int READ_WRITE_STORAGE = 52;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationComponentsView();
    }

    private void initializationComponentsView(){
        progressDialog = new ProgressDialog(this);
    }

    protected boolean isHasStoragePermissionOrIsSdkHigherThan28() {
        if (isHasStoragePermission() || isSdkHigherThan28()) {
            return true;
        } else {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return false;
        }
    }

    protected boolean isHasStoragePermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PERMISSION_GRANTED;
    }

    protected boolean requestPermission(String permission) {
        boolean isGranted = ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
        if (!isGranted) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{permission},
                    READ_WRITE_STORAGE);
        }
        return isGranted;
    }

    protected void showLoading(@NonNull String message) {
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    protected void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

}
