package com.threeao4.greenpentadudes.beerd2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.util.Log;


public class search extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);

    }

    public void expertsearchButtonClick(View b) {
        if (b.getId() == R.id.searchButton) {
            Intent i = new Intent(search.this, forum.class);
            Spinner typeSpinner=(Spinner) findViewById(R.id.typespinner);
            String typeofbeer = typeSpinner.getSelectedItem().toString();
            Spinner styleSpinner=(Spinner) findViewById(R.id.stylespinner);
            String styleofbeer = styleSpinner.getSelectedItem().toString();
            Spinner countrySpinner=(Spinner) findViewById(R.id.countryspinner);
            String country = countrySpinner.getSelectedItem().toString();

            //update previous searches
            if (homepage.p1.getCountryofSearch().equals("No info")){
                homepage.p1.updateInfo(typeofbeer,styleofbeer,country);
            }else if (homepage.p2.getCountryofSearch().equals("No info")){
                String t = homepage.p1.getTypeofSearch();
                String s = homepage.p1.getStyleofSearch();
                String c = homepage.p1.getCountryofSearch();
                homepage.p2.updateInfo(t,s,c);
                homepage.p1.updateInfo(typeofbeer,styleofbeer,country);
            }else{
                String t = homepage.p1.getTypeofSearch();
                String s = homepage.p1.getStyleofSearch();
                String c = homepage.p1.getCountryofSearch();
                String t1 = homepage.p2.getTypeofSearch();
                String s1 = homepage.p2.getStyleofSearch();
                String c1 = homepage.p2.getCountryofSearch();
                homepage.p3.updateInfo(t1,s1,c1);
                homepage.p2.updateInfo(t,s,c);
                homepage.p1.updateInfo(typeofbeer, styleofbeer, country);
            }



            if (country.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter a country",Toast.LENGTH_LONG).show();
            }else {

                //String apidata = "apidata";
                //String data = "data";
                //try{

                    //FileOutputStream fos = openFileOutput(apidata, Context.MODE_APPEND);
                    //Parser.start(fos);

                    //FileOutputStream fos2 = openFileOutput(data, Context.MODE_APPEND);
                    //InputStream is0 = openFileInput(apidata);
                    //Parser.parse(fos2,is0);
                //} catch (IOException e){
                    //e.printStackTrace();
                //}

                //controller

                InputStream is = getResources().openRawResource(R.raw.data);
                Controller controller = new Controller(is, typeofbeer, styleofbeer, country);


                //controller.getResults().get(0).name()
                //string parameter typeofbeer, styleofbeer, country



                if (!(controller.getResults().isEmpty())){
                    homepage.p1.updateBeerResult("1. " + controller.getResults().get(0).name());
                    if (!(controller.getResults().get(1).equals(""))){
                        homepage.p2.updateBeerResult("2. " + controller.getResults().get(1).name());
                    }else{
                        homepage.p2.updateBeerResult("Not Found");
                    }
                    if (!(controller.getResults().get(2).equals(""))) {
                        homepage.p3.updateBeerResult("3. " + controller.getResults().get(2).name());
                    }else{
                        homepage.p3.updateBeerResult("Not Found");
                    }

                    Toast.makeText(getApplicationContext(), "Found Results", Toast.LENGTH_LONG).show();
                }
                else{
                    homepage.p1.updateBeerResult("Not Found");
                    homepage.p2.updateBeerResult("Not Found");
                    homepage.p3.updateBeerResult("Not Found");
                    Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_LONG).show();
                }

                startActivity(i);
            }
        }
    }





}
