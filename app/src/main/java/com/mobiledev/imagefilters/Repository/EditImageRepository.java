package com.mobiledev.imagefilters.Repository;

import android.graphics.Bitmap;
import android.net.Uri;

public interface EditImageRepository {
    public Bitmap prepareImagePreview(Uri imageUri);
}
