package com.phoenix.codeutsava.maa.welcome_screen.model.data;

/**
 * Created by aman on 3/2/17.
 */

public class WelcomeScreenData {

    private boolean success;
    private String message;
    private String image_url;

    public WelcomeScreenData(boolean success, String message, String image_url) {
        this.success = success;
        this.message = message;
        this.image_url = image_url;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getImage_url() {
        return image_url;
    }
}
