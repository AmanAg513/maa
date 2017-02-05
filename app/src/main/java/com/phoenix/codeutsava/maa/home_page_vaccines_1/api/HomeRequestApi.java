package com.phoenix.codeutsava.maa.home_page_vaccines_1.api;

import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 4/2/17.
 */

public interface HomeRequestApi {

    @GET(Urls.REQUEST_HOME)
    Call<HomeData> requestHomeData(@Query("fcm") String fcm);
}
