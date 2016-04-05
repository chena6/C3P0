package com.threeao4.greenpentadudes.beerd2;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class forum extends AppCompatActivity{
    private CallbackManager callbackManager;
    private TextView facebookTxtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        facebook();
    }

    public void facebook(){


        callbackManager = CallbackManager.Factory.create();
        facebookTxtv = (TextView)findViewById(R.id.facebookTxtv);
        LoginButton loginButton = (LoginButton)findViewById(R.id.facebookbutton);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                facebookTxtv.setText("Login attempt Successful");
//                facebookTxtv.setText("User ID: "
//                        + loginResult.getAccessToken().getUserId()
//                        + "\n" +
//                        "Auth Token: "
//                        + loginResult.getAccessToken().getToken());
            }

            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                callbackManager.onActivityResult(requestCode, resultCode, data);
            }

            @Override
            public void onCancel() {
                facebookTxtv.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException error) {
                facebookTxtv.setText("Login attempt failed.");
            }
        });


    }

    public void homepageButtonClick(View b) {
        if(b.getId() == R.id.homepagebutton) {
            finish();
        }
    }

    

//    public void facebookbutton(View b) {
//        if(b.getId() == R.id.facebookbutton) {
//            finish();
//        }
//    }




}
