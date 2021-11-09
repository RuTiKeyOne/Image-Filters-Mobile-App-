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
        photoFilters.add(new Filter(R.drawable.brightness, PhotoFilter.BRIGHTNESS, "Brightness"));
        photoFilters.add(new Filter(R.drawable.contrast, PhotoFilter.CONTRAST, "Contrast"));
        photoFilters.add(new Filter(R.drawable.documentary, PhotoFilter.DOCUMENTARY, "Documentary"));
        photoFilters.add(new Filter(R.drawable.dual_tone, PhotoFilter.DUE_TONE, "Dual tone"));
        photoFilters.add(new Filter(R.drawable.fill_light, PhotoFilter.FILL_LIGHT, "Fill light"));
        photoFilters.add(new Filter(R.drawable.fish_eye, PhotoFilter.FISH_EYE, "Fish eye"));
        photoFilters.add(new Filter(R.drawable.grain, PhotoFilter.GRAIN, "Grain"));
        photoFilters.add(new Filter(R.drawable.gray_scale, PhotoFilter.GRAY_SCALE, "Gray scale"));
        photoFilters.add(new Filter(R.drawable.lomish, PhotoFilter.LOMISH, "Lomish"));
        photoFilters.add(new Filter(R.drawable.negative, PhotoFilter.NEGATIVE, "Negative"));
    }

    public static List<Filter> getPhotoFilters() {
        setupFilterData();
        return photoFilters;
    }
}
