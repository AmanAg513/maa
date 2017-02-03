package com.phoenix.codeutsava.maa.login.presenter;

import android.util.Log;

import com.phoenix.codeutsava.maa.login.LoginCallBack;
import com.phoenix.codeutsava.maa.login.OtpCallBack;
import com.phoenix.codeutsava.maa.login.model.LoginProvider;
import com.phoenix.codeutsava.maa.login.model.data.LoginData;
import com.phoenix.codeutsava.maa.login.model.data.OtpData;
import com.phoenix.codeutsava.maa.login.view.LoginView;
import com.phoenix.codeutsava.maa.login.view.OtpView;

/**
 * Created by aman on 3/2/17.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginProvider loginProvider;
    private OtpView otpView;

    public LoginPresenterImpl(LoginView loginView, LoginProvider loginProvider) {
        this.loginView = loginView;
        this.loginProvider = loginProvider;
    }

    public LoginPresenterImpl(OtpView otpview) {
        this.otpView = otpview;
    }

    @Override
    public void requestOtp(String otp, String mobile) {
        loginView.showLoading(true);
loginProvider.requestOtp(otp, mobile, new OtpCallBack() {
    @Override
    public void onSuccess(OtpData otpData) {

        if (otpData.isSuccess()) {
            loginView.showLoading(false);
          // loginView.onOtpVerified();
        } else {
            loginView.showLoading(false);
            loginView.showMessage(otpData.getMessage());

        }

    }

    @Override
    public void onFailure(String error) {
        loginView.showLoading(false);
        loginView.showMessage("Failed");

    }
});


    }

    @Override
    public void requestLogin(String name, String mobile, String fcm) {
        loginView.showLoading(true);
        loginProvider.requestLogin(name, mobile, fcm, new LoginCallBack() {
            @Override
            public void onSuccess(LoginData loginData) {
                if (loginData.isSuccess()) {
                    loginView.showLoading(false);
                    loginView.onLoginVerified();
                } else {
                    loginView.showLoading(false);
                    loginView.showMessage(loginData.getMessage());

                }
            }

            @Override
            public void onFailure(String error) {
                loginView.showLoading(false);
                loginView.showMessage("Failed");



            }
        });


    }
}
