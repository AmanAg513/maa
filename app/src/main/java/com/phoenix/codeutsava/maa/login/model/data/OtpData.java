package com.phoenix.codeutsava.maa.login.model.data;

/**
 * Created by aman on 3/2/17.
 */
public class OtpData {
    private String message;
    private boolean success;


    public OtpData(String message, boolean success) {
        this.message = message;
        this.success = success;

    }


    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }



}
