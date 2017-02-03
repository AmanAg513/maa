package com.phoenix.codeutsava.maa.login;

import com.phoenix.codeutsava.maa.login.model.data.OtpData;

/**
 * Created by aman on 3/2/17.
 */
public interface OtpCallBack {


    void onSuccess(OtpData otpData);

    void onFailure(String error);
}
