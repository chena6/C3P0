package com.example.mitchell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by mitchell on 4/3/16.
 */
public class PreviousSearchActivity extends AppCompatActivity{

    ListView prev_search;
    String[] beer_Names;
    String[] beer_Expert1_Info;
    String[] beer_Expert2_Info;
    String[] beer_Expert3_Info;
    BeerAdapter beerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_searches);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        prev_search = (ListView) findViewById(R.id.listView);

        beer_Names = getResources().getStringArray(R.array.Prev_Searched_Beers);
        beer_Expert1_Info = getResources().getStringArray(R.array.Expert1Info);
        beer_Expert2_Info = getResources().getStringArray(R.array.Expert2Info);
        beer_Expert3_Info = getResources().getStringArray(R.array.Expert3Info);
        beerAdapter = new BeerAdapter(getApplicationContext(),R.layout.entry_layout);
        prev_search.setAdapter(beerAdapter);
        for (int i = 0; i < beer_Names.length;i++) {

            BeerProvider beerProvider = new BeerProvider(beer_Names[i],beer_Expert1_Info[i]
                    ,beer_Expert2_Info[i],beer_Expert3_Info[i]);
            beerAdapter.add(beerProvider);

        }

    }
}
