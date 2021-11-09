package com.mobiledev.imagefilters.Model;

import android.util.Pair;

import com.mobiledev.imagefilters.R;

import java.util.ArrayList;
import java.util.List;

import ja.burhanrashid52.photoeditor.PhotoFilter;

public class FilterData {

    private static List<Filter> photoFilters = new ArrayList<>();

    private static void setupFilterData() {
        photoFilters.clear();
        photoFilters.add(new Filter(R.drawable.original, PhotoFilter.NONE, "None"));
        photoFilters.add(new Filter(R.drawable.auto_fix, PhotoFilter.AUTO_FIX, "Auto fix"));
    }

    public static List<Filter> getPhotoFilters() {
        setupFilterData();
        return photoFilters;
    }
}
