package com.phoenix.codeutsava.maa.home_page_vaccines_1.api;

import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 4/2/17.
 */

public interface FirstVaccineRequestApi {

    //homepage button click one
    @GET(Urls.REQUEST_FIRST_VACCINE)
    Call<FirstVaccineData> requestFirstVaccineData();
}
