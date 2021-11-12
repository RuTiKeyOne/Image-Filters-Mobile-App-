package com.mobiledev.imagefilters.Model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FilterDataTest {

    @Test
    public void getPhotoFiltersTest(){
        assertNotNull(FilterData.getPhotoFilters());
        assertTrue(FilterData.getPhotoFilters().size() > 0);
    }

}