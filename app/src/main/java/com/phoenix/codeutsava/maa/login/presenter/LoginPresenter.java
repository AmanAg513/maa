package com.phoenix.codeutsava.maa.login.presenter;

/**
 * Created by aman on 3/2/17.
 */
public interface LoginPresenter {
    void requestOtp(String otp, String mobile);

    void requestLogin(String name,String mobile,String fcm);



}
