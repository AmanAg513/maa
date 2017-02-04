package com.phoenix.codeutsava.maa.gallery.model.data;

import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingDataDetails;

import java.util.List;

/**
 * Created by aman on 4/2/17.
 */
public class GalleryData {
    private String message;
    private boolean success;
    private List<GalleryDataDetails> galleryDataDetailsList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }



    public List<GalleryDataDetails> getGalleryDataDetailsList() {
        return galleryDataDetailsList;
    }



    public GalleryData(String message, Boolean success, List<GalleryDataDetails> galleryDataDetailsList) {

        this.message = message;
        this.success = success;
        this.galleryDataDetailsList = galleryDataDetailsList;
    }
}
