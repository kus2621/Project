package com.example.rouletteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FreeCharge extends AppCompatActivity {

    private ArrayList<String> ad_list = new ArrayList<String>();

    ListView ad_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_charge);


        ad_listview = (ListView)findViewById(R.id.ad_listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this ,android.R.layout.simple_list_item_1,ad_list);

        ad_listview.setAdapter(adapter);




        adapter.notifyDataSetChanged();






    }
}
