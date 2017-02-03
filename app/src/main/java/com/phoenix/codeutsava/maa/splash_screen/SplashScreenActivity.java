package com.phoenix.codeutsava.maa.splash_screen;

import android.content.Intent;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.welcome_screen.view.WelcomeScreenActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    @BindView(R.id.splash_progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MultiDex.install(this);
        setContentView(R.layout.activity_splash_screen);

        ButterKnife.bind(this);
//        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//                progressBar.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(SplashScreenActivity.this, WelcomeScreenActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }


}
