package com.example.rouletteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShopActivity extends AppCompatActivity {


    private Button get_product;
    private TextView shop_text;
    private ImageView shop_image, product_name , product_inf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Intent intent = getIntent();

        shop_image = (ImageView)findViewById(R.id.shop_image);
        product_name = (ImageView)findViewById(R.id.product_name);
        product_inf = (ImageView)findViewById(R.id.product_inf);
        get_product = (Button)findViewById(R.id.get_proudct);
        shop_text = (TextView)findViewById(R.id.shop_text);



        shop_text.setText(intent.getStringExtra("item"));












    }
}
