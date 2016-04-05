package com.threeao4.greenpentadudes.beerd2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class forum extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forum);

    }

    public void homepageButtonClick(View b) {
        if(b.getId() == R.id.homepagebutton) {
            finish();
        }
    }

    public void mapStart(View v){

        Uri gmmIntentUri = Uri.parse("geo:0,0?q=lcbo");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

        //startActivity(new Intent(getApplicationContext(), MapsActivity.class));
    }


}
