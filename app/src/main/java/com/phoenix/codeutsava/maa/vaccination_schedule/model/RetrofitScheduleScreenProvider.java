package com.phoenix.codeutsava.maa.vaccination_schedule.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.vaccination_schedule.ScheduleScreenCallBack;
import com.phoenix.codeutsava.maa.vaccination_schedule.api.ScheduleScreenApi;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.ScheduleScreenData;

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

public class RetrofitScheduleScreenProvider implements ScheduleScreenProvider{

    private ScheduleScreenApi scheduleScreenApi;
    @Override
    public void requestScheduleData(final ScheduleScreenCallBack scheduleScreenCallBack) {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        scheduleScreenApi = retrofit.create(ScheduleScreenApi.class);
        Call<ScheduleScreenData> call=scheduleScreenApi.requestScheduleData();
        call.enqueue(new Callback<ScheduleScreenData>() {
            @Override
            public void onResponse(Call<ScheduleScreenData> call, Response<ScheduleScreenData> response) {
                scheduleScreenCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ScheduleScreenData> call, Throwable t) {
                t.printStackTrace();
                scheduleScreenCallBack.onFailure("Unable to Connect");
            }
        });



    }
}
