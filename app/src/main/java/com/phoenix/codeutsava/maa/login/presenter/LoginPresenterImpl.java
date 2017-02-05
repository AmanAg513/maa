package com.phoenix.codeutsava.maa.login.presenter;

import android.util.Log;

import com.phoenix.codeutsava.maa.login.LoginCallBack;
import com.phoenix.codeutsava.maa.login.OtpCallBack;
import com.phoenix.codeutsava.maa.login.model.LoginProvider;
import com.phoenix.codeutsava.maa.login.model.data.LoginData;
import com.phoenix.codeutsava.maa.login.model.data.OtpData;
import com.phoenix.codeutsava.maa.login.view.LoginView;

/**
 * Created by aman on 3/2/17.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginProvider loginProvider;

    public LoginPresenterImpl(LoginView loginView, LoginProvider loginProvider) {
        this.loginView = loginView;
        this.loginProvider = loginProvider;
    }
  @Override
    public void requestOtp(String otp, String mobile) {
        loginView.showLoading(true);
loginProvider.requestOtp(otp, mobile, new OtpCallBack() {
    @Override
    public void onSuccess(OtpData otpData) {
        if (otpData.isSuccess()) {
            loginView.showLoading(false);
             loginView.onOtpVerified();
        } else {
            loginView.showLoading(false);
            loginView.showMessage(otpData.getMessage());
        }

    }

    @Override
    public void onFailure(String error) {
        loginView.showLoading(false);
        loginView.showMessage("Failed aa ");

    }
});


    }

    @Override
    public void requestLogin(String name, String mobile, String fcm,String dueDate) {
        loginView.showLoading(true);
        loginProvider.requestLogin(name, mobile, fcm,dueDate, new LoginCallBack() {
            @Override
            public void onSuccess(LoginData loginData) {
                if (loginData.isSuccess()) {
                    loginView.showLoading(false);
                    loginView.onLoginVerified();
                    Log.d("response","login verified call");
                } else {
                    loginView.showLoading(false);
                    loginView.showMessage(loginData.getMessage());
                    Log.d("response","request login ka else");
                }
            }

            @Override
            public void onFailure(String error) {
                loginView.showLoading(false);
                loginView.showMessage("Failed");
                Log.d("response","call back failure");


            }
        });


    }
}
