package com.phoenix.codeutsava.maa.welcome_screen.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.helper.SharedPrefs;
import com.phoenix.codeutsava.maa.helper.image_loader.GlideImageLoader;
import com.phoenix.codeutsava.maa.helper.image_loader.ImageLoader;
import com.phoenix.codeutsava.maa.home.HomePage;
import com.phoenix.codeutsava.maa.login.view.LoginViewImpl;
import com.phoenix.codeutsava.maa.welcome_screen.model.RetrofitWelcomeScreenProvider;
import com.phoenix.codeutsava.maa.welcome_screen.model.data.WelcomeScreenData;
import com.phoenix.codeutsava.maa.welcome_screen.presenter.WelcomeScreenPresenter;
import com.phoenix.codeutsava.maa.welcome_screen.presenter.WelcomeScreenPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aman on 3/2/17.
 */

public class WelcomeScreenActivity extends Activity implements WelcomeScreenView{

    @BindView(R.id.button_welcome)
    Button button;

    @BindView(R.id.progressBar_welcome)
    ProgressBar progressBar;

    @BindView(R.id.txt_progressBar)
    ProgressBar txtProgressBar;

    @BindView(R.id.img_welcome)
    ImageView imageView;

    private TextView textView;

    private WelcomeScreenPresenter welcomeScreenPresenter;
    private ImageLoader imageLoader;
    private SharedPrefs sharedPrefs;

//    private WelcomeScreenData welcomeScreenData;




    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        ButterKnife.bind(this);
        sharedPrefs=new SharedPrefs(this);
        textView=(TextView)findViewById(R.id.txt_welcome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!sharedPrefs.isLoggedIn())
                {
                Intent intent = new Intent(WelcomeScreenActivity.this, LoginViewImpl.class);
                startActivity(intent);
                finish();
                }
                else{
                    Intent intent = new Intent(WelcomeScreenActivity.this, HomePage.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
//        txtProgressBar=(ProgressBar)findViewById(R.id.txt_progressBar);
//        progressBar=(ProgressBar)findViewById(R.id.progressBar_welcome);
        welcomeScreenPresenter = new WelcomeScreenPresenterImpl(this, new RetrofitWelcomeScreenProvider());
        welcomeScreenPresenter.requestWelcomeData();
    }
    @Override
    public void showProgressBar(boolean show) {
        if(show)
            txtProgressBar.setVisibility(View.VISIBLE);
        else
            txtProgressBar.setVisibility(View.INVISIBLE);


    }

    @Override
    public void showMessage(WelcomeScreenData welcomeScreenData) {
        textView.setText(welcomeScreenData.getMessage());
        imageLoader = new GlideImageLoader(this);
//      imageLoader = new GlideImageLoader(this);
        imageLoader.loadImage(welcomeScreenData.getImage_url(),imageView,progressBar);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(WelcomeScreenActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
