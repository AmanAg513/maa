package com.phoenix.codeutsava.maa.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.helper.MyApplication;
import com.phoenix.codeutsava.maa.helper.SharedPrefs;
import com.phoenix.codeutsava.maa.login.model.LoginRetrofitProvider;
import com.phoenix.codeutsava.maa.login.presenter.LoginPresenter;
import com.phoenix.codeutsava.maa.login.presenter.LoginPresenterImpl;
import com.phoenix.codeutsava.maa.welcome_screen.view.WelcomeScreenActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aman on 3/2/17.
 */
public class LoginViewImpl extends Activity implements LoginView  {



    EditText otp;
    Button otpButton;
    TextView text;
    TextView text2;

    String name1;
    EditText name;
    Button login_button;
    EditText mobile;
    String mobile1;
    EditText email;
    String otp1;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private SharedPrefs sharedPrefs;
    private ProgressBar progressbar;
    private LoginRetrofitProvider LoginRetrofitProvider;
    private LoginPresenter loginScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        sharedPrefs = new SharedPrefs(this);
        progressbar = (ProgressBar) findViewById(R.id.progressBar);

        login_button = (Button) findViewById(R.id.button1);
        name = (EditText) findViewById(R.id.editText1);
        mobile = (EditText) findViewById(R.id.editText2);
        text=(TextView) findViewById(R.id.textView);
        otpButton=(Button) findViewById(R.id.button2);
        otp=(EditText) findViewById(R.id.editText3);
        loginScreenPresenter = new LoginPresenterImpl(this, new LoginRetrofitProvider());

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1 = name.getText().toString();
                mobile1 = mobile.getText().toString();

                Log.d("Response", "b1");
                if (name1.equals("") || name1.equals(null)) {
                    name.setError("Please fill name");
                    name.requestFocus();
                } else if (mobile1.equals("") || mobile1.equals(null)) {
                    mobile.setError("Please fill mobile");
                    mobile.requestFocus();
               } else if (mobile1.length() != 10) {
                    mobile.setError("Invalid Mobile No.");
                    mobile.requestFocus();
                }

                if ((name1.equals("") || name1.equals(null)) ||
                        ((mobile1.equals("") || mobile1.equals(null)) || mobile1.length() != 10)

                        )

                {


                } else {

                    loginScreenPresenter.requestLogin(name1, mobile1, MyApplication.getFcm());
                    Log.d("response","fcm call");

                    sharedPrefs = new SharedPrefs(LoginViewImpl.this);
                    sharedPrefs.setFcm( MyApplication.getFcm());

                        Log.d("response","fcm send");
                }



            }
        });


        Log.d("Response", "6");

        otpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp1= otp.getText().toString();
                if (otp1.equals("") ) {
                    otp.setError("Please fill otp");
                    otp.requestFocus();
                }
                else{loginScreenPresenter.requestOtp(otp1,mobile1);
                    otpButton.setText("resend otp");





                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            text2.setVisibility(View.VISIBLE);
                            otpButton.setEnabled(false);


                        }
                    },30000);

                }
            }
        });

    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressbar.setVisibility(View.VISIBLE);
        } else {
            progressbar.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onLoginVerified() {

        text.setVisibility(View.VISIBLE);
        otp.setVisibility(View.VISIBLE);
        otpButton.setVisibility(View.VISIBLE);

    }


   @Override
    public void onOtpVerified() {


    }
    @Override
    public void onBackPressed() {
        //    super.onBackPressed();
        Intent intent = new Intent(LoginViewImpl.this, WelcomeScreenActivity.class);
        startActivity(intent);
        finish();

    }

}
