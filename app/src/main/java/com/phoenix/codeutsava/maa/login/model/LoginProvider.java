package com.phoenix.codeutsava.maa.login.model;

/**
 * Created by aman on 3/2/17.
 */
import com.phoenix.codeutsava.maa.login.OtpCallBack;
 import com.phoenix.codeutsava.maa.login.LoginCallBack;


public interface LoginProvider {
    void requestLogin(String name, String mobile, String fcm,String dueDate, LoginCallBack loginUsCallback);


    void requestOtp(String otp, String mobile, OtpCallBack otpCallBack);

}
