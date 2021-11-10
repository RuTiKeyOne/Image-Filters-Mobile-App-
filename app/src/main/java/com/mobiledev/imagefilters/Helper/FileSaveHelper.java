package com.mobiledev.imagefilters.Helper;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.Manifest;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleObserver;

import com.mobiledev.imagefilters.Interfaces.OnFileCreateResult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileSaveHelper implements LifecycleObserver {

    private OnFileCreateResult fileCreateListener;
    private final ExecutorService executor;
    private String filePath;
    private Cursor cursor;

    public FileSaveHelper() {
        executor = Executors.newSingleThreadExecutor();
    }

    public void createFile(final String fileNameToSave, OnFileCreateResult listener) {
        this.fileCreateListener = listener;
        createFileWithExecutor();
    }

    private void createFileWithExecutor() {
        executor.submit(() -> {
            cursor = null;
            try {
                createFileWithExecutorTry();
            } catch (final Exception ex) {
                createFileWithExecutorCatch(ex);
            } finally {
                createFileWithExecutorFinally();
            }
        });
    }

    private void createFileWithExecutorTry(){
        final ContentValues newImageDetails = new ContentValues();
        Uri imageCollection = buildUriCollection(newImageDetails);

    }


    private void createFileWithExecutorCatch(Exception ex){
        ex.printStackTrace();
        updateResult(false, null, ex.getMessage(), null, null);
    }

    private void createFileWithExecutorFinally(){
        if(cursor != null){
            cursor.close();
        }
    }

    private Uri buildUriCollection(ContentValues newImageDetails) {
        return null;
    }

    private void updateResult(boolean result, String filePath, String error, Uri uri, ContentValues newImageDetails){}

    public static boolean isSdkHigherThan28() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q);
    }

}
