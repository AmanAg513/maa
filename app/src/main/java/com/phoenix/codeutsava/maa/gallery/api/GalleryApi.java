package com.phoenix.codeutsava.maa.gallery.api;

import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingData;
import com.phoenix.codeutsava.maa.gallery.model.data.GalleryData;
import com.phoenix.codeutsava.maa.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 4/2/17.
 */
public interface GalleryApi {

    @GET(Urls.REQUEST_GALLERY)

    Call<GalleryData> getGAllery(@Query("fcm") String fcm);




}
