package com.phoenix.codeutsava.maa.gallery;

import com.phoenix.codeutsava.maa.gallery.model.data.GalleryData;

/**
 * Created by aman on 4/2/17.
 */
public interface GalleryCallBack {

    void onSuccess(GalleryData galleryData);
    void OnFailure(String message);
}
