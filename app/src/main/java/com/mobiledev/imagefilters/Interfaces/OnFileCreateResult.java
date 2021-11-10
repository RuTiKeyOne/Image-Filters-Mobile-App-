package com.mobiledev.imagefilters.Interfaces;

import android.net.Uri;

public interface OnFileCreateResult {
    void onFileCreateResult(boolean created, String filePath, String error, Uri Uri);
}
