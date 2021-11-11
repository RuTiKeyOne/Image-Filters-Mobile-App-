package com.mobiledev.imagefilters.Model;

import android.content.ContentValues;
import android.net.Uri;

public class FileMeta {
    public ContentValues imageDetails;
    public boolean isCreated;
    public String filePath;
    public Uri uri;
    public String error;

    public FileMeta(boolean isCreated, String filePath,
                    Uri uri, String error,
                    ContentValues newImageDetails) {
        this.isCreated = isCreated;
        this.filePath = filePath;
        this.uri = uri;
        this.error = error;
        this.imageDetails = newImageDetails;
    }
}
