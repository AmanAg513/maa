package com.phoenix.codeutsava.maa.gallery.presenter;

import com.phoenix.codeutsava.maa.further_reading.model.FurtherReadingProvider;
import com.phoenix.codeutsava.maa.further_reading.view.FurtherReadingView;
import com.phoenix.codeutsava.maa.gallery.GalleryCallBack;
import com.phoenix.codeutsava.maa.gallery.model.GalleryProvider;
import com.phoenix.codeutsava.maa.gallery.model.data.GalleryData;
import com.phoenix.codeutsava.maa.gallery.view.GalleryView;

/**
 * Created by aman on 4/2/17.
 */
public class GalleryPresenterImpl implements GalleryPresenter {
    private GalleryView galleryView;
    private GalleryProvider galleryProvider;


    public GalleryPresenterImpl(GalleryView galleryView, GalleryProvider galleryProvider) {
        this.galleryView = galleryView;
        this.galleryProvider = galleryProvider;
    }

    @Override
    public void requestGallery() {
        galleryProvider.requestGallery( new GalleryCallBack() {
            @Override
            public void onSuccess(GalleryData galleryData) {
                if (galleryData.getSuccess()) {
                    galleryView.showLoading(false);
                    galleryView.onVerified(galleryData.getGalleryDataDetailsList());
                } else {
                    galleryView.showLoading(false);
                    galleryView.showMessage(galleryData.getMessage());
                }
            }
            @Override
            public void OnFailure(String message) {
                galleryView.showLoading(false);
                galleryView.showMessage("Please try again in some time");

            }
        });

    }








}
