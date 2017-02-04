package com.phoenix.codeutsava.maa.gallery.model.data;

import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingDataDetails;

import java.util.List;

/**
 * Created by aman on 4/2/17.
 */
public class GalleryData {
    private String message;
    private Boolean Success;
    private List<GalleryDataDetails> galleryDataDetailsList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public List<GalleryDataDetails> getGalleryDataDetailsList() {
        return galleryDataDetailsList;
    }

    public void setGalleryDataDetailsList(List<GalleryDataDetails> galleryDataDetailsList) {
        this.galleryDataDetailsList = galleryDataDetailsList;
    }

    public GalleryData(String message, Boolean success, List<GalleryDataDetails> galleryDataDetailsList) {

        this.message = message;
        Success = success;
        this.galleryDataDetailsList = galleryDataDetailsList;
    }
}
