package com.mobiledev.imagefilters.Model;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import ja.burhanrashid52.photoeditor.PhotoFilter;

public class FilterTest {

    Filter filter = new Filter(1, PhotoFilter.FLIP_HORIZONTAL, "name");

    @Test
    public void filterConstructorTest(){
        assertNotNull(filter.getImageId());
        assertNotNull(filter.getPhotoFilter());
        assertNotNull(filter.getName());
    }
}