package com.example.rouletteproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Check extends AppCompatActivity {


    private ListView ck_list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_check);

            ck_list =(ListView)findViewById(R.id.ck_list);

        CheckDbHelper dbHelper = CheckDbHelper.getInstance(this);
        Cursor cursor = dbHelper.getReadableDatabase().query(CheckContract.CheckEntry.TABLE_NAME,
                null, null, null, null, null, null);
        //데이터베이스 가져오는코드 모든 데이터를 가져오고 싶으면 모든 값을 null로 하면 됨


        MemoAdapter adapter = new MemoAdapter(this, cursor);
        ck_list.setAdapter(adapter);
    }


    private static class MemoAdapter extends CursorAdapter {


        public MemoAdapter(Context context, Cursor c ) {
            super(context, c , false);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context)
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            TextView titleText = view.findViewById(android.R.id.text1);
            titleText.setText(cursor.getString(cursor.getColumnIndexOrThrow(CheckContract.CheckEntry.COLUMN_NAME_TITLE)));

        }
    }




}

