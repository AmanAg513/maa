package com.phoenix.codeutsava.maa.home_page_vaccines_1.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.FirstVaccineCallBack;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.HomeCallBack;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.api.FirstVaccineRequestApi;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.api.HomeRequestApi;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineData;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 4/2/17.
 */

public class RetrofitFirstVaccineProvider implements  FirstVaccineProvider, HomeRequestProvider{

    private FirstVaccineRequestApi firstVaccineRequestApi;

    private HomeRequestApi homeRequestApi;

    private Retrofit retrofit;

    public RetrofitFirstVaccineProvider()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
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

    @Override
    public void requestHomeData(String fcm, final HomeCallBack homeCallBack) {

        homeRequestApi = retrofit.create(HomeRequestApi.class);
        Call<HomeData> call = homeRequestApi.requestHomeData(fcm);
        call.enqueue(new Callback<HomeData>() {
            @Override
            public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                homeCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<HomeData> call, Throwable t) {
                t.printStackTrace();
                homeCallBack.onFailure();
            }
        });


    }
}
