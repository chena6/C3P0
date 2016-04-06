package com.threeao4.greenpentadudes.beerd2;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class prevsearch extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevsearch);

        //search 1
        final TextView mTypeTextView1 = (TextView) findViewById(R.id.typedata1);
        mTypeTextView1.setText(homepage.p1.getTypeofSearch());
        final TextView mStyleTextView1 = (TextView) findViewById(R.id.styledata1);
        mStyleTextView1.setText(homepage.p1.getStyleofSearch());
        final TextView mCountryTextView1 = (TextView) findViewById(R.id.countrydata1);
        mCountryTextView1.setText(homepage.p1.getCountryofSearch());

        //search 2

        final TextView mTypeTextView2 = (TextView) findViewById(R.id.typedata2);
        mTypeTextView2.setText(homepage.p2.getTypeofSearch());
        final TextView mStyleTextView2 = (TextView) findViewById(R.id.styledata2);
        mStyleTextView2.setText(homepage.p2.getStyleofSearch());
        final TextView mCountryTextView2 = (TextView) findViewById(R.id.countrydata2);
        mCountryTextView2.setText(homepage.p2.getCountryofSearch());

        //search 3

        final TextView mTypeTextView3 = (TextView) findViewById(R.id.typedata3);
        mTypeTextView3.setText(homepage.p3.getTypeofSearch());
        final TextView mStyleTextView3 = (TextView) findViewById(R.id.styledata3);
        mStyleTextView3.setText(homepage.p3.getStyleofSearch());
        final TextView mCountryTextView3 = (TextView) findViewById(R.id.countrydata3);
        mCountryTextView3.setText(homepage.p3.getCountryofSearch());

    }

    public void prevSearchFirstButtonClick(View b) {


        if (b.getId() == R.id.prevsearchbutton1) {
            InputStream is = getResources().openRawResource(R.raw.data);
            Intent i = new Intent(prevsearch.this, forum.class);
            Controller controller = new Controller(is, homepage.p1.getTypeofSearch(), homepage.p1.getStyleofSearch(), homepage.p1.getCountryofSearch());
            if (homepage.p1.getTypeofSearch().equals("No info")){
                Toast.makeText(getApplicationContext(), "Search first to use previous searches", Toast.LENGTH_LONG).show();
            }
            else if (!(controller.getResults().isEmpty())) {
                homepage.p1.updateBeerResult("1. " + controller.getResults().get(0).name());
                if (!(controller.getResults().get(1).equals(""))) {
                    homepage.p2.updateBeerResult("2. " + controller.getResults().get(1).name());
                } else {
                    homepage.p2.updateBeerResult("Not Found");
                }
                if (!(controller.getResults().get(2).equals(""))) {
                    homepage.p3.updateBeerResult("3. " + controller.getResults().get(2).name());
                } else {
                    homepage.p3.updateBeerResult("Not Found");
                }

                Toast.makeText(getApplicationContext(), "Found Results", Toast.LENGTH_LONG).show();
                startActivity(i);
            } else {
                homepage.p1.updateBeerResult("Not Found");
                homepage.p2.updateBeerResult("Not Found");
                homepage.p3.updateBeerResult("Not Found");
                Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_LONG).show();
                startActivity(i);
            }


        }

        if (b.getId() == R.id.prevsearchbutton2) {
            InputStream is = getResources().openRawResource(R.raw.data);
            Intent i = new Intent(prevsearch.this, forum.class);
            Controller controller = new Controller(is, homepage.p2.getTypeofSearch(), homepage.p2.getStyleofSearch(), homepage.p2.getCountryofSearch());

            if (homepage.p2.getTypeofSearch().equals("No info")){
                Toast.makeText(getApplicationContext(), "Search first to use previous searches", Toast.LENGTH_LONG).show();
            }
            else if (!(controller.getResults().isEmpty())) {
                homepage.p1.updateBeerResult("1. " + controller.getResults().get(0).name());
                if (!(controller.getResults().get(1).equals(""))) {
                    homepage.p2.updateBeerResult("2. " + controller.getResults().get(1).name());
                } else {
                    homepage.p2.updateBeerResult("Not Found");
                }
                if (!(controller.getResults().get(2).equals(""))) {
                    homepage.p3.updateBeerResult("3. " + controller.getResults().get(2).name());
                } else {
                    homepage.p3.updateBeerResult("Not Found");
                }

                Toast.makeText(getApplicationContext(), "Found Results", Toast.LENGTH_LONG).show();
                startActivity(i);
            } else {
                homepage.p1.updateBeerResult("Not Found");
                homepage.p2.updateBeerResult("Not Found");
                homepage.p3.updateBeerResult("Not Found");
                Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_LONG).show();
                startActivity(i);
            }


        }

        if (b.getId() == R.id.prevsearchbutton3) {
            InputStream is = getResources().openRawResource(R.raw.data);
            Intent i = new Intent(prevsearch.this, forum.class);
            Controller controller = new Controller(is, homepage.p3.getTypeofSearch(), homepage.p3.getStyleofSearch(), homepage.p3.getCountryofSearch());

            if (homepage.p3.getTypeofSearch().equals("No info")){
                Toast.makeText(getApplicationContext(), "Search first to use previous searches", Toast.LENGTH_LONG).show();
            }
            else if (!(controller.getResults().isEmpty())) {
                homepage.p1.updateBeerResult("1. " + controller.getResults().get(0).name());
                if (!(controller.getResults().get(1).equals(""))) {
                    homepage.p2.updateBeerResult("2. " + controller.getResults().get(1).name());
                } else {
                    homepage.p2.updateBeerResult("Not Found");
                }
                if (!(controller.getResults().get(2).equals(""))) {
                    homepage.p3.updateBeerResult("3. " + controller.getResults().get(2).name());
                } else {
                    homepage.p3.updateBeerResult("Not Found");
                }

                Toast.makeText(getApplicationContext(), "Found Results", Toast.LENGTH_LONG).show();
                startActivity(i);
            } else {
                homepage.p1.updateBeerResult("Not Found");
                homepage.p2.updateBeerResult("Not Found");
                homepage.p3.updateBeerResult("Not Found");
                Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_LONG).show();
                startActivity(i);
            }


        }



    }
}