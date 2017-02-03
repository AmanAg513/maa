package com.phoenix.codeutsava.maa.welcome_screen.api;

import com.phoenix.codeutsava.maa.helper.Urls;
import com.phoenix.codeutsava.maa.welcome_screen.model.data.WelcomeScreenData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 3/2/17.
 */

public interface WelcomeScreenRequestApi {

    @GET(Urls.REQUEST_WELCOME_SCREEN)
    Call<WelcomeScreenData> requestWelcome();
}
