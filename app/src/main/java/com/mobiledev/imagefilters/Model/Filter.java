package com.mobiledev.imagefilters.Model;

import ja.burhanrashid52.photoeditor.PhotoFilter;

public class Filter {
    private int imageId;
    private PhotoFilter photoFilter;
    private String name;

    public Filter(int imageId, PhotoFilter photoFilter, String name) {
        this.imageId = imageId;
        this.photoFilter = photoFilter;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public PhotoFilter getPhotoFilter() {
        return photoFilter;
    }

    public String getName() {
        return name;
    }
}
