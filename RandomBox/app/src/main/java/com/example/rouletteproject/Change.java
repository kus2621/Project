package com.example.rouletteproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Change extends AppCompatActivity{

    ListView product_list;
    private TextView usable_point ;

    private ArrayList<String> data = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        product_list = (ListView)findViewById(R.id.change_list);
        usable_point = (TextView)findViewById(R.id.usable_point);

        CheckDbHelper dbHelper = CheckDbHelper.getInstance(this);
        dbHelper.getReadableDatabase().query(CheckContract.CheckEntry.TABLE_NAME,
                null,null,null,null,null,null);


        data.add("문화상품권 10000원");
        data.add("문화상품권 5000원");
        data.add("문화상품권 3000원");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);
        //여기까지 어댑터 연동및 아이템 설정

       product_list.setAdapter(adapter);



        Cursor cursor = dbHelper.getReadableDatabase().query(CheckContract.CheckEntry.TABLE_NAME,
                null, null, null, null, null, null);


                product_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                            AlertDialog.Builder product_ad1 = new AlertDialog.Builder(Change.this);
                            product_ad1.setMessage("이 상품을 선택하시겠습니까?");
                            product_ad1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int position) {

                                    Intent intent = new Intent(Change.this, ShopActivity.class);
                                    startActivity(intent);
                                }


                            });
                            product_ad1.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                        }
                                    }
                            );
                            product_ad1.show();

    }
});
    }
}

