package com.phoenix.codeutsava.maa.maps.api;

import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.maps.model.data.GeotagData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GeotagApi {

    @GET(Urls.REQUEST_GEOTAGS)
    Call<GeotagData> requestGeotag();
}
