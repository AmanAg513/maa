package com.phoenix.codeutsava.maa.discuss.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenix.codeutsava.maa.discuss.DiscussQuestionCallBack;
import com.phoenix.codeutsava.maa.discuss.api.DiscussQuestionRequestApi;
import com.phoenix.codeutsava.maa.discuss.model.data.DiscussQuestionData;
import com.phoenix.codeutsava.maa.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 5/2/17.
 */

public class RetrofitDiscussQuestionProvider implements DiscussQuestionProvider {

    private DiscussQuestionRequestApi discussQuestionRequestApi;
    private Retrofit retrofit;

    public RetrofitDiscussQuestionProvider(){
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
    public void requestDiscussQuestion(final DiscussQuestionCallBack discussQuestionCallBack) {
        discussQuestionRequestApi = retrofit.create(DiscussQuestionRequestApi.class);
        Call<DiscussQuestionData> call = discussQuestionRequestApi.requestDiscussQuestion();
        call.enqueue(new Callback<DiscussQuestionData>() {
            @Override
            public void onResponse(Call<DiscussQuestionData> call, Response<DiscussQuestionData> response) {
                discussQuestionCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DiscussQuestionData> call, Throwable t) {
                t.printStackTrace();
                discussQuestionCallBack.onFailure();
            }
        });

    }
}
