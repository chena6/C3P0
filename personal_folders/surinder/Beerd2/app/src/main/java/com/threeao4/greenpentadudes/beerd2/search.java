package com.threeao4.greenpentadudes.beerd2;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;


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
            EditText countrytext = (EditText)findViewById(R.id.countrytext);
            String country = countrytext.getText().toString();
            if (country.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter a country",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(), "type: " + typeofbeer + " style: " + styleofbeer + " country: " + country, Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        }
    }


}
