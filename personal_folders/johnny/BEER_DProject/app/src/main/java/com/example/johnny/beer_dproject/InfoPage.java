package com.example.johnny.beer_dproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infopage);

        //ListFill();
    }

    public void Back(View v){
        Intent intent = new Intent(this,Homepage.class);
        startActivity(intent);
    }

    public void ListFill(){
        String[] genInfoArray = {"BeerInfo","How to use BEER'D","LCBO","Experts"};
        String[] genInfoArray2 = {"Beer is a Drink","Run the app and search","The Liquor Control Board of Ontario is a thing","This is some information on the three experts used"};

        ArrayAdapter<String> genInfoArrayAdaptor = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, genInfoArray);
        ListView genInfoListView = (ListView)findViewById(R.id.genInfoList);
        genInfoListView.setAdapter(genInfoArrayAdaptor);
    }






}
