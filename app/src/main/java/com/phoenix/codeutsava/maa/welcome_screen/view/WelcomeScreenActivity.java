package com.phoenix.codeutsava.maa.welcome_screen.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.helper.image_loader.GlideImageLoader;
import com.phoenix.codeutsava.maa.helper.image_loader.ImageLoader;
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

//    @BindView(R.id.progressBar_welcome)
//    ProgressBar progressBar;

//    @BindView(R.id.txt_progressBar)
//    ProgressBar txtProgressBar;

    @BindView(R.id.img_welcome)
    ImageView imageView;

    @BindView(R.id.txt_welcome)
    TextView textView;

    private WelcomeScreenPresenter welcomeScreenPresenter;
    private ImageLoader imageLoader;
    private Context context;
    private ProgressBar txtProgressBar;
    private ProgressBar progressBar;

//    private WelcomeScreenData welcomeScreenData;




    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ButterKnife.bind(this);

        txtProgressBar=(ProgressBar)findViewById(R.id.txt_progressBar);
        progressBar=(ProgressBar)findViewById(R.id.progressBar_welcome);
        welcomeScreenPresenter = new WelcomeScreenPresenterImpl(this,
                new RetrofitWelcomeScreenProvider());
        welcomeScreenPresenter.requestWelcomeData();

//        showMessage(welcomeScreenData);
    }
    @Override
    public void showProgressBar(boolean show) {
        if(show)
        {
            txtProgressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            txtProgressBar.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void showMessage(WelcomeScreenData welcomeScreenData) {
        String message=welcomeScreenData.getMessage().toString();
        textView.setText(message);
        imageLoader = new GlideImageLoader(context);
        imageLoader.loadImage(welcomeScreenData.getImage_url(),imageView,progressBar);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(WelcomeScreenActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
