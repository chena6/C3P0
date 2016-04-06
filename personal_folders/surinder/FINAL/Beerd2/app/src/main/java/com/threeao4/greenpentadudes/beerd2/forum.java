package com.threeao4.greenpentadudes.beerd2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class forum extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forum);

        final TextView mBeerResult1 = (TextView) findViewById(R.id.beerResultText1);
        mBeerResult1.setText(homepage.p1.getBeerResult());
        final TextView mBeerResult2 = (TextView) findViewById(R.id.beerResultText2);
        mBeerResult2.setText(homepage.p2.getBeerResult());
        final TextView mBeerResult3 = (TextView) findViewById(R.id.beerResultText3);
        mBeerResult3.setText(homepage.p3.getBeerResult());


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
