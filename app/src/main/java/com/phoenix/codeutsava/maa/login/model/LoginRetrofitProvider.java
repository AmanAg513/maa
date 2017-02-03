package com.phoenix.codeutsava.maa.login.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenix.codeutsava.maa.login.LoginCallBack;
import com.phoenix.codeutsava.maa.login.OtpCallBack;
import com.phoenix.codeutsava.maa.login.api.LoginApi;
import com.phoenix.codeutsava.maa.login.api.OtpApi;
import com.phoenix.codeutsava.maa.login.model.data.LoginData;
import com.phoenix.codeutsava.maa.login.model.data.OtpData;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.phoenix.codeutsava.maa.login.OtpCallBack;
/**
 * Created by aman on 3/2/17.
 */
public class LoginRetrofitProvider implements LoginProvider{
    private LoginApi loginApi;
    private OtpApi otpApi;

    public LoginRetrofitProvider() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loginApi = retrofit.create(LoginApi.class);
        otpApi=retrofit.create(OtpApi.class);

    }

    @Override
    public void requestLogin(String name, String mobile, String fcm, final LoginCallBack loginUsCallback) {


        Call<LoginData> loginDataCall = loginApi.requestLogin(name, mobile, fcm);
        loginDataCall.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {



                loginUsCallback.onSuccess(response.body());
            }



            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {

                loginUsCallBack.onFailure("Unable to connect");

                t.printStackTrace();

            }
        });
    }
    @Override
    public void requestOtp(String otp, String mobile,final  OtpCallBack otpCallBack) {


        Call<OtpData> otpDataCall = otpApi.requestOtp(otp, mobile);

        otpDataCall.enqueue(new Callback<OtpData>() {
            @Override
            public void onResponse(Call<OtpData> call, Response<OtpData> response) {

                otpCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<OtpData> call, Throwable t) {
                t.printStackTrace();
               otpCallBack.onFailure("Unable to connect");

            }
        });

    }
}