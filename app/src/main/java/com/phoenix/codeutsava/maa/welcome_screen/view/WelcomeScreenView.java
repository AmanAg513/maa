package com.phoenix.codeutsava.maa.welcome_screen.view;

import com.phoenix.codeutsava.maa.welcome_screen.model.data.WelcomeScreenData;

/**
 * Created by aman on 3/2/17.
 */

public interface WelcomeScreenView {

    void showProgressBar(boolean show);
    void showMessage(WelcomeScreenData welcomeScreenData);
    void showError(String error);
}
