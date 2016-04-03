package com.example.johnny.beer_dproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }



    public void ToGenInfo(View v){
        Intent intent = new Intent(this,InfoPage.class);
        startActivity(intent);
    }
}
