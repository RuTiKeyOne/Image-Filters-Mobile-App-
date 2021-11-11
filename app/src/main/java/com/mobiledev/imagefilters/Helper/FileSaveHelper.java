package com.mobiledev.imagefilters.Helper;

import android.annotation.SuppressLint;
import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.*;
import androidx.lifecycle.OnLifecycleEvent;
import com.mobiledev.imagefilters.Interfaces.OnFileCreateResult;
import com.mobiledev.imagefilters.Model.FileMeta;
import java.io.*;
import java.util.concurrent.*;


public class FileSaveHelper implements LifecycleObserver {
    private final ContentResolver contentResolver;
    private final ExecutorService executor;
    private final MutableLiveData<FileMeta> fileCreatedResult;
    private OnFileCreateResult resultListener;
    private final Observer<FileMeta> observer = fileMeta -> {
        if (resultListener != null) {
            resultListener.onFileCreateResult(fileMeta.isCreated,
                    fileMeta.filePath,
                    fileMeta.error,
                    fileMeta.uri);
        }
    };

    public FileSaveHelper(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
        executor = Executors.newSingleThreadExecutor();
        fileCreatedResult = new MutableLiveData<>();
    }

    public FileSaveHelper(AppCompatActivity activity) {
        this(activity.getContentResolver());
        addObserver(activity);
    }

    private void addObserver(LifecycleOwner lifecycleOwner) {
        fileCreatedResult.observe(lifecycleOwner, observer);
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void release() {
        if (null != executor) {
            executor.shutdownNow();
        }
    }

    public static boolean isSdkHigherThan28() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q);
    }

    public void createFile(final String fileNameToSave, OnFileCreateResult listener) {
        this.resultListener = listener;
        executor.submit(() -> {
            Cursor cursor = null;
            String filePath;
            try {
                final ContentValues newImageDetails = new ContentValues();
                Uri imageCollection = buildUriCollection(newImageDetails);
                final Uri editedImageUri = getEditedImageUri(fileNameToSave, newImageDetails, imageCollection);
                filePath = getFilePath(cursor, editedImageUri);
                updateResult(true, filePath, null, editedImageUri, newImageDetails);
            } catch (final Exception ex) {
                ex.printStackTrace();
                updateResult(false, null, ex.getMessage(), null, null);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        });
    }

    private String getFilePath(Cursor cursor, Uri editedImageUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        cursor = contentResolver.query(editedImageUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    private Uri getEditedImageUri(String fileNameToSave, ContentValues newImageDetails, Uri imageCollection) throws IOException {
        newImageDetails.put(MediaStore.Images.Media.DISPLAY_NAME, fileNameToSave);
        final Uri editedImageUri = contentResolver.insert(imageCollection, newImageDetails);
        final OutputStream outputStream = contentResolver.openOutputStream(editedImageUri);
        outputStream.close();
        return editedImageUri;
    }

    @SuppressLint("InlinedApi")
    private Uri buildUriCollection(ContentValues newImageDetails) {
        Uri imageCollection = null;
        if (isSdkHigherThan28()) {
            imageCollection = MediaStore.Images.Media.getContentUri(
                    MediaStore.VOLUME_EXTERNAL_PRIMARY
            );
            newImageDetails.put(MediaStore.Images.Media.IS_PENDING, 1);
        } else {
            imageCollection = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        return imageCollection;
    }


    @SuppressLint("InlinedApi")
    public void notifyThatFileIsNowPubliclyAvailable(ContentResolver contentResolver) {
        if (isSdkHigherThan28()) {
            executor.submit(() -> {
                updateContentResolver();
            });
        }
    }

    private void updateContentResolver() {
        FileMeta value = fileCreatedResult.getValue();
        if (value != null) {
            value.imageDetails.clear();
            value.imageDetails.put(MediaStore.Images.Media.IS_PENDING, 0);
            contentResolver.update(value.uri, value.imageDetails, null, null);
        }
    }

    private void updateResult(boolean result, String filePath, String error, Uri uri, ContentValues newImageDetails) {
        fileCreatedResult.postValue(new FileMeta(result, filePath, uri, error, newImageDetails));
    }
}
