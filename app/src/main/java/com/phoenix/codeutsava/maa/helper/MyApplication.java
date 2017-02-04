package com.phoenix.codeutsava.maa.helper;

import android.app.Application;
import android.content.Context;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by aman on 3/2/17.
 */
public class MyApplication extends Application {

    private static Context context;
    private static String fcm;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        //     FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/comfortaa.ttf");
        //    FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/homemade.ttf");
//        FontsOverride.setDefaultFont(this, "SERIF", "fonts/itim.ttf");
           FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/patrick_hand.ttf");

        fcm = FirebaseInstanceId.getInstance().getToken();

    }

    public static String getFcm() {
        return fcm;
    }

    public static Context getContext() {
        return context;
    }



}
