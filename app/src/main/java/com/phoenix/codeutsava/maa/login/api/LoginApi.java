package com.phoenix.codeutsava.maa.login.api;

/**
 * Created by aman on 3/2/17.
 */


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import com.phoenix.codeutsava.maa.login.model.data.LoginData;

public interface LoginApi {


        @FormUrlEncoded
        @POST(Urls.SEND_OTP)
        Call<LoginData> requestLogin(@Field("name") String name, @Field("mobile") String mobile,
                                     @Field("fcm") String fcm);


    }


}