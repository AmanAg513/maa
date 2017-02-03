package com.phoenix.codeutsava.maa.login.api;

/**
 * Created by aman on 3/2/17.
 */

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import com.phoenix.codeutsava.maa.login.model.data.OtpData;
public interface OtpApi {
    @FormUrlEncoded
    @POST(Urls.VERIFY_OTP)
    Call<OtpData> requestOtp(@Field("otp") String otp, @Field("mobile") String mobile);




}
