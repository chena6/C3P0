package com.example.johnny.beer_dproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopage);
    }

    public void Back(View v){
        Intent intent = new Intent(this,Homepage.class);
        startActivity(intent);
    }
}
