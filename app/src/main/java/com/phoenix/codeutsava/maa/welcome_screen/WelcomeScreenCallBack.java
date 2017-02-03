package com.phoenix.codeutsava.maa.welcome_screen;

import com.phoenix.codeutsava.maa.welcome_screen.model.data.WelcomeScreenData;

/**
 * Created by aman on 3/2/17.
 */

public interface WelcomeScreenCallBack {

    void onSuccess(WelcomeScreenData welcomeScreenData);
    void onFailure ();
}
