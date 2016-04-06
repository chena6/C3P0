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
                    Toast.makeText(getApplicationContext(), controller.getResults().get(0).name(), Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
                }

                startActivity(i);
            }
        }
    }





}
