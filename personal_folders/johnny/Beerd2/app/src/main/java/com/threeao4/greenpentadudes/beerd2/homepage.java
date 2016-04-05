package com.threeao4.greenpentadudes.beerd2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.FacebookSdk;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        FacebookSdk.sdkInitialize(getApplicationContext());
    }

    public void ongeninfoButtonClick(View b) {
        if (b.getId() == R.id.geninfoButton) {
            Intent i = new Intent(homepage.this, geninfo.class);
            startActivity(i);
        }
    }
    public void onsearchButtonClick(View b) {
        if(b.getId() == R.id.searchpageButton) {
            Intent j = new Intent(homepage.this, search.class);
            startActivity(j);
        }
    }

    public void onprevsearchButtonClick(View b) {
        if(b.getId() == R.id.prevsearchButton) {
            Intent k = new Intent(homepage.this, prevsearch.class);
            startActivity(k);
        }
    }

}

