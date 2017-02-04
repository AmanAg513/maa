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
        Log.d("Response","1");
        welcomeScreenView.showProgressBar(true);
        Log.d("Response","2");
        welcomeScreenProvider.requestWelcomeData(new WelcomeScreenCallBack() {
            @Override
            public void onSuccess(WelcomeScreenData welcomeScreenData) {
                Log.d("Response","3");
                if(welcomeScreenData.isSuccess())
                {
                    Log.d("Response","4");
                    welcomeScreenView.showMessage(welcomeScreenData);
                    welcomeScreenView.showProgressBar(false);
                }
                else
                {
                    Log.d("Response","5");
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
