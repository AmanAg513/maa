package com.phoenix.codeutsava.maa.login;

import com.phoenix.codeutsava.maa.login.model.data.LoginData;

/**
 * Created by aman on 3/2/17.
 */
public interface LoginCallBack {
    void onSuccess(LoginData loginData);

    void onFailure(String error);







}
