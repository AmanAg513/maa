package com.phoenix.codeutsava.maa.further_reading.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenix.codeutsava.maa.further_reading.FurtherReadingCallBack;
import com.phoenix.codeutsava.maa.further_reading.api.FurtherReadingApi;
import com.phoenix.codeutsava.maa.further_reading.model.data.FurtherReadingData;
import com.phoenix.codeutsava.maa.helper.Urls;
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
public class FurtherReadingRetrofitProvider implements FurtherReadingProvider{
    private FurtherReadingApi furtherReadingApi;
    private Retrofit retrofit;

    public FurtherReadingRetrofitProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Override
    public void requestFurtherReading(final FurtherReadingCallBack furtherReadingCallBack) {


      furtherReadingApi = retrofit.create(FurtherReadingApi.class);
Call<FurtherReadingData> furtherReadingDataCall=furtherReadingApi.getCities();
        furtherReadingDataCall.enqueue(new Callback<FurtherReadingData>() {
            @Override
            public void onResponse(Call<FurtherReadingData> call, Response<FurtherReadingData> response) {
                furtherReadingCallBack.onSuccess(response.body())  ;
                Log.d("response","retrofit ka call back ka success");
            }

            @Override
            public void onFailure(Call<FurtherReadingData> call, Throwable t) {
                furtherReadingCallBack.onFailure("UnableTo Connect");
                t.printStackTrace();
                Log.d("response","retrofit ke call back ka failure");
            }
        });
    }
}
