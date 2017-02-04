package com.phoenix.codeutsava.maa.welcome_screen.presenter;

import android.util.Log;

import com.phoenix.codeutsava.maa.welcome_screen.WelcomeScreenCallBack;
import com.phoenix.codeutsava.maa.welcome_screen.model.WelcomeScreenProvider;
import com.phoenix.codeutsava.maa.welcome_screen.model.data.WelcomeScreenData;
import com.phoenix.codeutsava.maa.welcome_screen.view.WelcomeScreenView;

/**
 * Created by aman on 3/2/17.
 */

public class WelcomeScreenPresenterImpl implements WelcomeScreenPresenter{

    private WelcomeScreenView welcomeScreenView;
    private WelcomeScreenProvider welcomeScreenProvider;

    public WelcomeScreenPresenterImpl(WelcomeScreenView welcomeScreenView, WelcomeScreenProvider welcomeScreenProvider) {
        this.welcomeScreenView = welcomeScreenView;
        this.welcomeScreenProvider = welcomeScreenProvider;
    }

    @Override
    public void requestWelcomeData() {
//        welcomeScreenView.showProgressBar(true);
        welcomeScreenProvider.requestWelcomeData(new WelcomeScreenCallBack() {
            @Override
            public void onSuccess(WelcomeScreenData welcomeScreenData) {
                if(welcomeScreenData.isSuccess())
                {
                    welcomeScreenView.showMessage(welcomeScreenData);
                    welcomeScreenView.showProgressBar(false);
                    welcomeScreenView.showError("Success");
                }

                else
                {
                    welcomeScreenView.showProgressBar(false);
                    welcomeScreenView.showError("Something went wrong");
                }

            }

            @Override
            public void onFailure() {
//
                welcomeScreenView.showError("Failed");
                welcomeScreenView.showProgressBar(false);
            }
        });
    }
}
