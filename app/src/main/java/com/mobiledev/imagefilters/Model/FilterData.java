package com.mobiledev.imagefilters.Model;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

import ja.burhanrashid52.photoeditor.PhotoFilter;

public class FilterData {

    private static List<Pair<String, PhotoFilter>> photoFilters = new ArrayList<>();

    private static void setupFilterData() {
        photoFilters.clear();
        photoFilters.add(new Pair<>("drawable/original.jpg", PhotoFilter.NONE));
    }

    public static List<Pair<String, PhotoFilter>> getPhotoFilters() {
        setupFilterData();
        return photoFilters;
    }
}
