package com.phoenix.codeutsava.maa.login.view;

/**
 * Created by aman on 3/2/17.
 */
public interface LoginView {
    void showLoading(boolean show);

    void showMessage(String message);

    void onLoginVerified();
    void onOtpVerified(String token);

}
