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
        photoFilters.add(new Filter(R.drawable.auto_fix, PhotoFilter.AUTO_FIX, "Auto Fix"));
        photoFilters.add(new Filter(R.drawable.brightness, PhotoFilter.BRIGHTNESS, "Brightness"));
        photoFilters.add(new Filter(R.drawable.contrast, PhotoFilter.CONTRAST, "Contrast"));
        photoFilters.add(new Filter(R.drawable.documentary, PhotoFilter.DOCUMENTARY, "Documentary"));
        photoFilters.add(new Filter(R.drawable.dual_tone, PhotoFilter.DUE_TONE, "Dual Tone"));
        photoFilters.add(new Filter(R.drawable.fill_light, PhotoFilter.FILL_LIGHT, "Fill Light"));
        photoFilters.add(new Filter(R.drawable.fish_eye, PhotoFilter.FISH_EYE, "Fish Eye"));
        photoFilters.add(new Filter(R.drawable.grain, PhotoFilter.GRAIN, "Grain"));
        photoFilters.add(new Filter(R.drawable.gray_scale, PhotoFilter.GRAY_SCALE, "Gray Scale"));
        photoFilters.add(new Filter(R.drawable.lomish, PhotoFilter.LOMISH, "Lomish"));
        photoFilters.add(new Filter(R.drawable.negative, PhotoFilter.NEGATIVE, "Negative"));
        photoFilters.add(new Filter(R.drawable.posterize, PhotoFilter.POSTERIZE, "Posterize"));
        photoFilters.add(new Filter(R.drawable.saturate, PhotoFilter.SATURATE, "Saturate"));
        photoFilters.add(new Filter(R.drawable.sepia, PhotoFilter.SEPIA, "Sepia"));
        photoFilters.add(new Filter(R.drawable.sharpen, PhotoFilter.SHARPEN, "Sharpen"));
        photoFilters.add(new Filter(R.drawable.temprature, PhotoFilter.TEMPERATURE, "Temperature"));
        photoFilters.add(new Filter(R.drawable.tint, PhotoFilter.TINT, "Tint"));
        photoFilters.add(new Filter(R.drawable.vignette, PhotoFilter.VIGNETTE, "Vignette"));
        photoFilters.add(new Filter(R.drawable.cross_process, PhotoFilter.CROSS_PROCESS, "Cross Process"));
        photoFilters.add(new Filter(R.drawable.b_n_w, PhotoFilter.BLACK_WHITE, "Black White"));
        photoFilters.add(new Filter(R.drawable.flip_horizental, PhotoFilter.FLIP_HORIZONTAL, "Flip Horizontal"));
        photoFilters.add(new Filter(R.drawable.flip_vertical, PhotoFilter.FLIP_VERTICAL, "Flip Vertical"));
        photoFilters.add(new Filter(R.drawable.rotate, PhotoFilter.ROTATE, "Rotate"));
    }

    public static List<Filter> getPhotoFilters() {
        setupFilterData();
        return photoFilters;
    }
}
