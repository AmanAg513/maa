package com.phoenix.codeutsava.maa.gallery.view;

import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingDataDetails;
import com.phoenix.codeutsava.maa.gallery.model.data.GalleryDataDetails;

import java.util.List;

/**
 * Created by aman on 4/2/17.
 */
public interface GalleryView {



    void showLoading(boolean show);

    void showMessage(String message);

    void onVerified(List<GalleryDataDetails> galleryDataDetailsList);
}
