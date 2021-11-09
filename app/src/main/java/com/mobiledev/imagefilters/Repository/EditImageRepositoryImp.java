package com.mobiledev.imagefilters.Repository;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class EditImageRepositoryImp implements EditImageRepository {

    private Context context;

    public EditImageRepositoryImp(Context context) {
        this.context = context;
    }

    @Override
    public Bitmap prepareImagePreview(Uri imageUri) {
        if(getInputStreamFromTry(imageUri) != null){
            InputStream inputStream = getInputStreamFromTry(imageUri);
            return BitmapFactory.decodeStream(inputStream);
        }
        throw new NullPointerException("getInputStreamFromTry return null");
    }

    private InputStream getInputStreamFromTry(Uri uri){
        try {
           return getInputStreamFromUri(uri);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private InputStream getInputStreamFromUri(Uri uri) throws FileNotFoundException {
        return context.getContentResolver().openInputStream(uri);
    }
}
