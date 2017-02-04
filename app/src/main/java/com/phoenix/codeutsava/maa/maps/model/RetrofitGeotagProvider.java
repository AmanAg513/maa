package com.phoenix.codeutsava.maa.maps.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.maps.GeotagCallBack;
import com.phoenix.codeutsava.maa.maps.api.GeotagApi;
import com.phoenix.codeutsava.maa.maps.model.data.GeotagData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 3/2/17.
 */

public class RetrofitGeotagProvider implements GeotagProvider {

    private GeotagApi geotagApi;
    private Retrofit retrofit;
    public RetrofitGeotagProvider()
    {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Override
    public void requestWelcomeData(final GeotagCallBack geotagCallBack) {
        geotagApi = retrofit.create(GeotagApi.class);
        Call<GeotagData> call= geotagApi.requestGeotag();
        call.enqueue(new Callback<GeotagData>() {
            @Override
            public void onResponse(Call<GeotagData> call, Response<GeotagData> response) {
                geotagCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<GeotagData> call, Throwable t) {
                t.printStackTrace();
                geotagCallBack.onFailure();
            }
        });
    }
}
