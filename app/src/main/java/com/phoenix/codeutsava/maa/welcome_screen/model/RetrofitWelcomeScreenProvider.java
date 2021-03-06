package com.phoenix.codeutsava.maa.welcome_screen.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.welcome_screen.WelcomeScreenCallBack;
import com.phoenix.codeutsava.maa.welcome_screen.api.WelcomeScreenRequestApi;
import com.phoenix.codeutsava.maa.welcome_screen.model.data.WelcomeScreenData;

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

public class RetrofitWelcomeScreenProvider implements WelcomeScreenProvider {

    private WelcomeScreenRequestApi welcomeScreenRequestApi;
    private Retrofit retrofit;

    public RetrofitWelcomeScreenProvider()
    {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

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
    public void requestWelcomeData(final WelcomeScreenCallBack welcomeScreenCallBack) {
        welcomeScreenRequestApi = retrofit.create(WelcomeScreenRequestApi.class);
        Call<WelcomeScreenData> call= welcomeScreenRequestApi.requestWelcome();
        call.enqueue(new Callback<WelcomeScreenData>() {
            @Override
            public void onResponse(Call<WelcomeScreenData> call, Response<WelcomeScreenData> response) {
                welcomeScreenCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<WelcomeScreenData> call, Throwable t) {
                t.printStackTrace();
                welcomeScreenCallBack.onFailure();
            }
        });
    }
}
