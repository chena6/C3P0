package com.example.mitchell.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mitchell on 4/3/16.
 */
public class BeerAdapter extends ArrayAdapter{

    List list = new ArrayList();

    public BeerAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();

    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View entry;
        entry = convertView;
        DataHandler handler;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            entry = inflater.inflate(R.layout.entry_layout,parent,false);
            handler = new DataHandler();
            handler.name = (TextView) entry.findViewById(R.id.beer_name);
            handler.info1 = (TextView) entry.findViewById(R.id.expert1);
            handler.info2 = (TextView) entry.findViewById(R.id.expert2);
            handler.info3 = (TextView) entry.findViewById(R.id.expert3);
            entry.setTag(handler);
        }
        else {
            handler = (DataHandler) entry.getTag();
        }
        BeerProvider beerProvider = (BeerProvider) this.getItem(position);
        handler.name.setText(beerProvider.getBeer_Name());
        handler.info1.setText(beerProvider.getExpert_Info_1());
        handler.info2.setText(beerProvider.getExpert_Info_2());
        handler.info3.setText(beerProvider.getExpert_Info_3());

        return entry;
    }


    static class DataHandler{

        TextView name;
        TextView info1;
        TextView info2;
        TextView info3;
    }

}
