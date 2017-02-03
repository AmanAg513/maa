package com.phoenix.codeutsava.maa.home_page_vaccines_1.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.FirstVaccineCallBack;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.api.FirstVaccineRequestApi;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 4/2/17.
 */

public class RetrofitFirstVaccineProvider implements  FirstVaccineProvider{

    private FirstVaccineRequestApi firstVaccineRequestApi;
    private Retrofit retrofit;

    public RetrofitFirstVaccineProvider()
    {
        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }


    @Override
    public void requestFirstVaccineData(final FirstVaccineCallBack firstVaccineCallBack) {

        firstVaccineRequestApi = retrofit.create(FirstVaccineRequestApi.class);
        Call<FirstVaccineData> call = firstVaccineRequestApi.requestFirstVaccineData();
        call.enqueue(new Callback<FirstVaccineData>() {
            @Override
            public void onResponse(Call<FirstVaccineData> call, Response<FirstVaccineData> response) {
                firstVaccineCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FirstVaccineData> call, Throwable t) {
                t.printStackTrace();
                firstVaccineCallBack.onFailure();
            }
        });

    }
}
