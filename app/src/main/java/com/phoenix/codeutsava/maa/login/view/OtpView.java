package com.phoenix.codeutsava.maa.login.view;

/**
 * Created by aman on 3/2/17.
 */
public interface OtpView {

    void showOtpLoading(boolean show);

    void showOtpMessage(String message);

    void onOtpVerified(String token);

}
