package com.example.rouletteproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_10,btn_11,btn_12,btn_13,btn_14,btn_15,btn_16,btn_17,btn_18,btn_19,btn_20, btn_21,btn_22,btn_23,btn_24,btn_25,btn_26,btn_27,btn_28,btn_29,btn_30,btn_31,
            btn_32,btn_33,btn_34,btn_35,btn_36,btn_37,btn_38,btn_39,btn_40,btn_41,btn_42,btn_43,btn_44,btn_45,btn_46,btn_47,btn_48,btn_49,btn_50;
    String[] num ={"10", "10", "10", "10", "10","10","10","10","10","10","10","20", "20", "20", "20", "20", "20","20","20", "30", "30", "40", "50"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        final Random rnd_Num = new Random();

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);

        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_10 = (Button) findViewById(R.id.btn_10);

        btn_11 = (Button) findViewById(R.id.btn_11);
        btn_12 = (Button) findViewById(R.id.btn_12);
        btn_13 = (Button) findViewById(R.id.btn_13);
        btn_14 = (Button) findViewById(R.id.btn_14);
        btn_15 = (Button) findViewById(R.id.btn_15);

        btn_16 = (Button) findViewById(R.id.btn_16);
        btn_17 = (Button) findViewById(R.id.btn_17);
        btn_18 = (Button) findViewById(R.id.btn_18);
        btn_19 = (Button) findViewById(R.id.btn_19);
        btn_20 = (Button) findViewById(R.id.btn_20);

        btn_21 = (Button) findViewById(R.id.btn_21);
        btn_22 = (Button) findViewById(R.id.btn_22);
        btn_23 = (Button) findViewById(R.id.btn_23);
        btn_24 = (Button) findViewById(R.id.btn_24);
        btn_25 = (Button) findViewById(R.id.btn_25);

        btn_26 = (Button) findViewById(R.id.btn_26);
        btn_27 = (Button) findViewById(R.id.btn_27);
        btn_28 = (Button) findViewById(R.id.btn_28);
        btn_29 = (Button) findViewById(R.id.btn_29);
        btn_30 = (Button) findViewById(R.id.btn_30);

        btn_31 = (Button) findViewById(R.id.btn_31);
        btn_32 = (Button) findViewById(R.id.btn_32);
        btn_33 = (Button) findViewById(R.id.btn_33);
        btn_34 = (Button) findViewById(R.id.btn_34);
        btn_35 = (Button) findViewById(R.id.btn_35);

        btn_36 = (Button) findViewById(R.id.btn_36);
        btn_37 = (Button) findViewById(R.id.btn_37);
        btn_38 = (Button) findViewById(R.id.btn_38);
        btn_39 = (Button) findViewById(R.id.btn_39);
        btn_40 = (Button) findViewById(R.id.btn_40);

        btn_41 = (Button) findViewById(R.id.btn_41);
        btn_42 = (Button) findViewById(R.id.btn_42);
        btn_43 = (Button) findViewById(R.id.btn_43);
        btn_44 = (Button) findViewById(R.id.btn_44);
        btn_45 = (Button) findViewById(R.id.btn_45);

        btn_46 = (Button) findViewById(R.id.btn_46);
        btn_47 = (Button) findViewById(R.id.btn_47);
        btn_48 = (Button) findViewById(R.id.btn_48);
        btn_49 = (Button) findViewById(R.id.btn_49);
        btn_50 = (Button) findViewById(R.id.btn_50);


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck1 = new AlertDialog.Builder(PlayActivity.this);
                ck1.setMessage("이 상자를 선택하시겠습니까?");
                ck1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_1_txt = (num[p] + "p");
                        btn_1.setText(btn_1_txt);
                        btn_1.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_1_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad1 = new AlertDialog.Builder(PlayActivity.this);
                        ad1.setMessage(btn_1_txt + "포인트가 당첨 되었습니다!!");


                        ad1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad1.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad1.show();

                    }
                });
                ck1.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck1.show();


            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck2 = new AlertDialog.Builder(PlayActivity.this);
                ck2.setMessage("이 상자를 선택하시겠습니까?");
                ck2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_2_txt = (num[p] + "p");
                        btn_2.setText(btn_2_txt);
                        btn_2.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_2_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad2 = new AlertDialog.Builder(PlayActivity.this);
                        ad2.setMessage(btn_2_txt + "포인트가 당첨 되었습니다!!");


                        ad2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad2.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad2.show();

                    }
                });
                ck2.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck2.show();


            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck3 = new AlertDialog.Builder(PlayActivity.this);
                ck3.setMessage("이 상자를 선택하시겠습니까?");
                ck3.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_3_txt = (num[p] + "p");
                        btn_3.setText(btn_3_txt);
                        btn_3.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_3_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad3 = new AlertDialog.Builder(PlayActivity.this);
                        ad3.setMessage(btn_3_txt + "포인트가 당첨 되었습니다!!");


                        ad3.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad3.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad3.show();

                    }
                });
                ck3.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck3.show();


            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck4 = new AlertDialog.Builder(PlayActivity.this);
                ck4.setMessage("이 상자를 선택하시겠습니까?");
                ck4.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_4_txt = (num[p] + "p");
                        btn_4.setText(btn_4_txt);
                        btn_4.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_4_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad4 = new AlertDialog.Builder(PlayActivity.this);
                        ad4.setMessage(btn_4_txt + "포인트가 당첨 되었습니다!!");


                        ad4.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad4.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad4.show();

                    }
                });
                ck4.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck4.show();


            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck5 = new AlertDialog.Builder(PlayActivity.this);
                ck5.setMessage("이 상자를 선택하시겠습니까?");
                ck5.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_5_txt = (num[p] + "p");
                        btn_5.setText(btn_5_txt);
                        btn_5.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_5_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad5 = new AlertDialog.Builder(PlayActivity.this);
                        ad5.setMessage(btn_5_txt + "포인트가 당첨 되었습니다!!");


                        ad5.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad5.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad5.show();

                    }
                });
                ck5.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck5.show();


            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck6 = new AlertDialog.Builder(PlayActivity.this);
                ck6.setMessage("이 상자를 선택하시겠습니까?");
                ck6.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_6_txt = (num[p] + "p");
                        btn_6.setText(btn_6_txt);
                        btn_6.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_6_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad6 = new AlertDialog.Builder(PlayActivity.this);
                        ad6.setMessage(btn_6_txt + "포인트가 당첨 되었습니다!!");


                        ad6.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad6.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad6.show();

                    }
                });
                ck6.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck6.show();


            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck7 = new AlertDialog.Builder(PlayActivity.this);
                ck7.setMessage("이 상자를 선택하시겠습니까?");
                ck7.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_7_txt = (num[p] + "p");
                        btn_7.setText(btn_7_txt);
                        btn_7.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_7_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad7 = new AlertDialog.Builder(PlayActivity.this);
                        ad7.setMessage(btn_7_txt + "포인트가 당첨 되었습니다!!");


                        ad7.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad7.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad7.show();

                    }
                });
                ck7.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck7.show();


            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck8 = new AlertDialog.Builder(PlayActivity.this);
                ck8.setMessage("이 상자를 선택하시겠습니까?");
                ck8.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_8_txt = (num[p] + "p");
                        btn_8.setText(btn_8_txt);
                        btn_8.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_8_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad8 = new AlertDialog.Builder(PlayActivity.this);
                        ad8.setMessage(btn_8_txt + "포인트가 당첨 되었습니다!!");


                        ad8.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad8.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad8.show();

                    }
                });
                ck8.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck8.show();


            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck9 = new AlertDialog.Builder(PlayActivity.this);
                ck9.setMessage("이 상자를 선택하시겠습니까?");
                ck9.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_9_txt = (num[p] + "p");
                        btn_9.setText(btn_9_txt);
                        btn_9.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_9_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad9 = new AlertDialog.Builder(PlayActivity.this);
                        ad9.setMessage(btn_9_txt + "포인트가 당첨 되었습니다!!");


                        ad9.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad9.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad9.show();

                    }
                });
                ck9.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck9.show();


            }
        });
        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck10 = new AlertDialog.Builder(PlayActivity.this);
                ck10.setMessage("이 상자를 선택하시겠습니까?");
                ck10.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_10_txt = (num[p] + "p");
                        btn_10.setText(btn_10_txt);
                        btn_10.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_10_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad10 = new AlertDialog.Builder(PlayActivity.this);
                        ad10.setMessage(btn_10_txt + "포인트가 당첨 되었습니다!!");


                        ad10.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad10.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad10.show();

                    }
                });
                ck10.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck10.show();


            }
        });
        btn_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck11 = new AlertDialog.Builder(PlayActivity.this);
                ck11.setMessage("이 상자를 선택하시겠습니까?");
                ck11.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_11_txt = (num[p] + "p");
                        btn_11.setText(btn_11_txt);
                        btn_11.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_11_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad11 = new AlertDialog.Builder(PlayActivity.this);
                        ad11.setMessage(btn_11_txt + "포인트가 당첨 되었습니다!!");


                        ad11.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad11.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad11.show();

                    }
                });
                ck11.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck11.show();


            }
        });
        btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck12 = new AlertDialog.Builder(PlayActivity.this);
                ck12.setMessage("이 상자를 선택하시겠습니까?");
                ck12.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_12_txt = (num[p] + "p");
                        btn_12.setText(btn_12_txt);
                        btn_12.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_12_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad12 = new AlertDialog.Builder(PlayActivity.this);
                        ad12.setMessage(btn_12_txt + "포인트가 당첨 되었습니다!!");


                        ad12.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad12.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad12.show();

                    }
                });
                ck12.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck12.show();


            }
        });
        btn_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck13 = new AlertDialog.Builder(PlayActivity.this);
                ck13.setMessage("이 상자를 선택하시겠습니까?");
                ck13.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_13_txt = (num[p] + "p");
                        btn_13.setText(btn_13_txt);
                        btn_13.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_13_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad13 = new AlertDialog.Builder(PlayActivity.this);
                        ad13.setMessage(btn_13_txt + "포인트가 당첨 되었습니다!!");


                        ad13.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad13.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad13.show();

                    }
                });
                ck13.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck13.show();


            }
        });
        btn_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck14 = new AlertDialog.Builder(PlayActivity.this);
                ck14.setMessage("이 상자를 선택하시겠습니까?");
                ck14.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_14_txt = (num[p] + "p");
                        btn_14.setText(btn_14_txt);
                        btn_14.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_14_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad14 = new AlertDialog.Builder(PlayActivity.this);
                        ad14.setMessage(btn_14_txt + "포인트가 당첨 되었습니다!!");


                        ad14.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad14.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad14.show();

                    }
                });
                ck14.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck14.show();


            }
        });
        btn_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck15 = new AlertDialog.Builder(PlayActivity.this);
                ck15.setMessage("이 상자를 선택하시겠습니까?");
                ck15.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_15_txt = (num[p] + "p");
                        btn_15.setText(btn_15_txt);
                        btn_15.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_15_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad15 = new AlertDialog.Builder(PlayActivity.this);
                        ad15.setMessage(btn_15_txt + "포인트가 당첨 되었습니다!!");


                        ad15.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad15.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad15.show();

                    }
                });
                ck15.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck15.show();


            }
        });
        btn_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck16 = new AlertDialog.Builder(PlayActivity.this);
                ck16.setMessage("이 상자를 선택하시겠습니까?");
                ck16.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_16_txt = (num[p] + "p");
                        btn_16.setText(btn_16_txt);
                        btn_16.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_16_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad16 = new AlertDialog.Builder(PlayActivity.this);
                        ad16.setMessage(btn_16_txt + "포인트가 당첨 되었습니다!!");


                        ad16.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad16.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad16.show();

                    }
                });
                ck16.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck16.show();


            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck17 = new AlertDialog.Builder(PlayActivity.this);
                ck17.setMessage("이 상자를 선택하시겠습니까?");
                ck17.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_17_txt = (num[p] + "p");
                        btn_17.setText(btn_17_txt);
                        btn_17.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_17_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad17 = new AlertDialog.Builder(PlayActivity.this);
                        ad17.setMessage(btn_17_txt + "포인트가 당첨 되었습니다!!");


                        ad17.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad17.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad17.show();

                    }
                });
                ck17.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck17.show();


            }
        });
        btn_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck18 = new AlertDialog.Builder(PlayActivity.this);
                ck18.setMessage("이 상자를 선택하시겠습니까?");
                ck18.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_18_txt = (num[p] + "p");
                        btn_18.setText(btn_18_txt);
                        btn_18.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_18_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad18 = new AlertDialog.Builder(PlayActivity.this);
                        ad18.setMessage(btn_18_txt + "포인트가 당첨 되었습니다!!");


                        ad18.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad18.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad18.show();

                    }
                });
                ck18.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck18.show();


            }
        });
        btn_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck19 = new AlertDialog.Builder(PlayActivity.this);
                ck19.setMessage("이 상자를 선택하시겠습니까?");
                ck19.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_19_txt = (num[p] + "p");
                        btn_19.setText(btn_19_txt);
                        btn_19.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_19_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad19 = new AlertDialog.Builder(PlayActivity.this);
                        ad19.setMessage(btn_19_txt + "포인트가 당첨 되었습니다!!");


                        ad19.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad19.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad19.show();

                    }
                });
                ck19.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck19.show();


            }
        });
        btn_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck20 = new AlertDialog.Builder(PlayActivity.this);
                ck20.setMessage("이 상자를 선택하시겠습니까?");
                ck20.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_20_txt = (num[p] + "p");
                        btn_20.setText(btn_20_txt);
                        btn_20.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_20_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad20 = new AlertDialog.Builder(PlayActivity.this);
                        ad20.setMessage(btn_20_txt + "포인트가 당첨 되었습니다!!");


                        ad20.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad20.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad20.show();

                    }
                });
                ck20.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck20.show();


            }
        });
        btn_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck21 = new AlertDialog.Builder(PlayActivity.this);
                ck21.setMessage("이 상자를 선택하시겠습니까?");
                ck21.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_21_txt = (num[p] + "p");
                        btn_21.setText(btn_21_txt);
                        btn_21.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_21_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad21 = new AlertDialog.Builder(PlayActivity.this);
                        ad21.setMessage(btn_21_txt + "포인트가 당첨 되었습니다!!");


                        ad21.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad21.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad21.show();

                    }
                });
                ck21.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck21.show();


            }
        });
        btn_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck22 = new AlertDialog.Builder(PlayActivity.this);
                ck22.setMessage("이 상자를 선택하시겠습니까?");
                ck22.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_22_txt = (num[p] + "p");
                        btn_22.setText(btn_22_txt);
                        btn_22.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_22_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad22 = new AlertDialog.Builder(PlayActivity.this);
                        ad22.setMessage(btn_22_txt + "포인트가 당첨 되었습니다!!");


                        ad22.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad22.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad22.show();

                    }
                });
                ck22.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck22.show();


            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck23 = new AlertDialog.Builder(PlayActivity.this);
                ck23.setMessage("이 상자를 선택하시겠습니까?");
                ck23.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_23_txt = (num[p] + "p");
                        btn_23.setText(btn_23_txt);
                        btn_23.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_23_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad23 = new AlertDialog.Builder(PlayActivity.this);
                        ad23.setMessage(btn_23_txt + "포인트가 당첨 되었습니다!!");


                        ad23.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad23.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad23.show();

                    }
                });
                ck23.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck23.show();


            }
        });
        btn_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck24 = new AlertDialog.Builder(PlayActivity.this);
                ck24.setMessage("이 상자를 선택하시겠습니까?");
                ck24.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_24_txt = (num[p] + "p");
                        btn_24.setText(btn_24_txt);
                        btn_24.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_24_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad24 = new AlertDialog.Builder(PlayActivity.this);
                        ad24.setMessage(btn_24_txt + "포인트가 당첨 되었습니다!!");


                        ad24.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad24.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad24.show();

                    }
                });
                ck24.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck24.show();


            }
        });
        btn_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck25 = new AlertDialog.Builder(PlayActivity.this);
                ck25.setMessage("이 상자를 선택하시겠습니까?");
                ck25.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_25_txt = (num[p] + "p");
                        btn_25.setText(btn_25_txt);
                        btn_25.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_25_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad25 = new AlertDialog.Builder(PlayActivity.this);
                        ad25.setMessage(btn_25_txt + "포인트가 당첨 되었습니다!!");


                        ad25.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad25.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad25.show();

                    }
                });
                ck25.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck25.show();


            }
        });

        btn_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck26 = new AlertDialog.Builder(PlayActivity.this);
                ck26.setMessage("이 상자를 선택하시겠습니까?");
                ck26.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_26_txt = (num[p] + "p");
                        btn_26.setText(btn_26_txt);
                        btn_26.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_26_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad26 = new AlertDialog.Builder(PlayActivity.this);
                        ad26.setMessage(btn_26_txt + "포인트가 당첨 되었습니다!!");


                        ad26.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad26.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad26.show();

                    }
                });
                ck26.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck26.show();


            }
        });
        btn_27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck27 = new AlertDialog.Builder(PlayActivity.this);
                ck27.setMessage("이 상자를 선택하시겠습니까?");
                ck27.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_27_txt = (num[p] + "p");
                        btn_27.setText(btn_27_txt);
                        btn_27.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_27_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad27 = new AlertDialog.Builder(PlayActivity.this);
                        ad27.setMessage(btn_27_txt + "포인트가 당첨 되었습니다!!");


                        ad27.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad27.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad27.show();

                    }
                });
                ck27.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck27.show();


            }
        });
        btn_28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck28 = new AlertDialog.Builder(PlayActivity.this);
                ck28.setMessage("이 상자를 선택하시겠습니까?");
                ck28.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_28_txt = (num[p] + "p");
                        btn_28.setText(btn_28_txt);
                        btn_28.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_28_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad28 = new AlertDialog.Builder(PlayActivity.this);
                        ad28.setMessage(btn_28_txt + "포인트가 당첨 되었습니다!!");


                        ad28.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad28.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad28.show();

                    }
                });
                ck28.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck28.show();


            }
        });
        btn_29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck29 = new AlertDialog.Builder(PlayActivity.this);
                ck29.setMessage("이 상자를 선택하시겠습니까?");
                ck29.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_29_txt = (num[p] + "p");
                        btn_29.setText(btn_29_txt);
                        btn_29.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_29_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad29 = new AlertDialog.Builder(PlayActivity.this);
                        ad29.setMessage(btn_29_txt + "포인트가 당첨 되었습니다!!");


                        ad29.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad29.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad29.show();

                    }
                });
                ck29.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck29.show();


            }
        });
        btn_30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck30 = new AlertDialog.Builder(PlayActivity.this);
                ck30.setMessage("이 상자를 선택하시겠습니까?");
                ck30.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_30_txt = (num[p] + "p");
                        btn_30.setText(btn_30_txt);
                        btn_30.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_30_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad30 = new AlertDialog.Builder(PlayActivity.this);
                        ad30.setMessage(btn_30_txt + "포인트가 당첨 되었습니다!!");


                        ad30.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad30.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad30.show();

                    }
                });
                ck30.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck30.show();


            }
        });
        btn_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck31 = new AlertDialog.Builder(PlayActivity.this);
                ck31.setMessage("이 상자를 선택하시겠습니까?");
                ck31.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_31_txt = (num[p] + "p");
                        btn_31.setText(btn_31_txt);
                        btn_31.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_31_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad31 = new AlertDialog.Builder(PlayActivity.this);
                        ad31.setMessage(btn_31_txt + "포인트가 당첨 되었습니다!!");


                        ad31.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad31.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad31.show();

                    }
                });
                ck31.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck31.show();


            }
        });
        btn_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck32 = new AlertDialog.Builder(PlayActivity.this);
                ck32.setMessage("이 상자를 선택하시겠습니까?");
                ck32.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_32_txt = (num[p] + "p");
                        btn_32.setText(btn_32_txt);
                        btn_32.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_32_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad32 = new AlertDialog.Builder(PlayActivity.this);
                        ad32.setMessage(btn_32_txt + "포인트가 당첨 되었습니다!!");


                        ad32.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad32.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad32.show();

                    }
                });
                ck32.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck32.show();


            }
        });
        btn_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck33 = new AlertDialog.Builder(PlayActivity.this);
                ck33.setMessage("이 상자를 선택하시겠습니까?");
                ck33.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_33_txt = (num[p] + "p");
                        btn_33.setText(btn_33_txt);
                        btn_33.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_33_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad33 = new AlertDialog.Builder(PlayActivity.this);
                        ad33.setMessage(btn_33_txt + "포인트가 당첨 되었습니다!!");


                        ad33.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad33.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad33.show();

                    }
                });
                ck33.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck33.show();


            }
        });
        btn_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck34 = new AlertDialog.Builder(PlayActivity.this);
                ck34.setMessage("이 상자를 선택하시겠습니까?");
                ck34.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_34_txt = (num[p] + "p");
                        btn_34.setText(btn_34_txt);
                        btn_34.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_34_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad34 = new AlertDialog.Builder(PlayActivity.this);
                        ad34.setMessage(btn_34_txt + "포인트가 당첨 되었습니다!!");


                        ad34.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad34.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad34.show();

                    }
                });
                ck34.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck34.show();


            }
        });
        btn_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck35 = new AlertDialog.Builder(PlayActivity.this);
                ck35.setMessage("이 상자를 선택하시겠습니까?");
                ck35.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_35_txt = (num[p] + "p");
                        btn_35.setText(btn_35_txt);
                        btn_35.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_35_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad35 = new AlertDialog.Builder(PlayActivity.this);
                        ad35.setMessage(btn_35_txt + "포인트가 당첨 되었습니다!!");


                        ad35.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad35.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad35.show();

                    }
                });
                ck35.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck35.show();


            }
        });
        btn_36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck36 = new AlertDialog.Builder(PlayActivity.this);
                ck36.setMessage("이 상자를 선택하시겠습니까?");
                ck36.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_36_txt = (num[p] + "p");
                        btn_36.setText(btn_36_txt);
                        btn_36.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_36_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad36 = new AlertDialog.Builder(PlayActivity.this);
                        ad36.setMessage(btn_36_txt + "포인트가 당첨 되었습니다!!");


                        ad36.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad36.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad36.show();

                    }
                });
                ck36.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck36.show();


            }
        });
        btn_37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck37 = new AlertDialog.Builder(PlayActivity.this);
                ck37.setMessage("이 상자를 선택하시겠습니까?");
                ck37.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_37_txt = (num[p] + "p");
                        btn_37.setText(btn_37_txt);
                        btn_37.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_37_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad37 = new AlertDialog.Builder(PlayActivity.this);
                        ad37.setMessage(btn_37_txt + "포인트가 당첨 되었습니다!!");


                        ad37.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad37.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad37.show();

                    }
                });
                ck37.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck37.show();


            }
        });
        btn_38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck38 = new AlertDialog.Builder(PlayActivity.this);
                ck38.setMessage("이 상자를 선택하시겠습니까?");
                ck38.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_38_txt = (num[p] + "p");
                        btn_38.setText(btn_38_txt);
                        btn_38.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_38_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad38 = new AlertDialog.Builder(PlayActivity.this);
                        ad38.setMessage(btn_38_txt + "포인트가 당첨 되었습니다!!");


                        ad38.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad38.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad38.show();

                    }
                });
                ck38.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck38.show();


            }
        });
        btn_39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck39 = new AlertDialog.Builder(PlayActivity.this);
                ck39.setMessage("이 상자를 선택하시겠습니까?");
                ck39.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_39_txt = (num[p] + "p");
                        btn_39.setText(btn_39_txt);
                        btn_39.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_39_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad39 = new AlertDialog.Builder(PlayActivity.this);
                        ad39.setMessage(btn_39_txt + "포인트가 당첨 되었습니다!!");


                        ad39.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad39.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad39.show();

                    }
                });
                ck39.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck39.show();


            }
        });
        btn_40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck40 = new AlertDialog.Builder(PlayActivity.this);
                ck40.setMessage("이 상자를 선택하시겠습니까?");
                ck40.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_40_txt = (num[p] + "p");
                        btn_40.setText(btn_40_txt);
                        btn_40.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_40_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad40 = new AlertDialog.Builder(PlayActivity.this);
                        ad40.setMessage(btn_40_txt + "포인트가 당첨 되었습니다!!");


                        ad40.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad40.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad40.show();

                    }
                });
                ck40.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck40.show();


            }
        });
        btn_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck41 = new AlertDialog.Builder(PlayActivity.this);
                ck41.setMessage("이 상자를 선택하시겠습니까?");
                ck41.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_41_txt = (num[p] + "p");
                        btn_41.setText(btn_41_txt);
                        btn_41.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_41_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad41 = new AlertDialog.Builder(PlayActivity.this);
                        ad41.setMessage(btn_41_txt + "포인트가 당첨 되었습니다!!");


                        ad41.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad41.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad41.show();

                    }
                });
                ck41.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck41.show();


            }
        });
        btn_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck42 = new AlertDialog.Builder(PlayActivity.this);
                ck42.setMessage("이 상자를 선택하시겠습니까?");
                ck42.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_42_txt = (num[p] + "p");
                        btn_42.setText(btn_42_txt);
                        btn_42.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_42_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad42 = new AlertDialog.Builder(PlayActivity.this);
                        ad42.setMessage(btn_42_txt + "포인트가 당첨 되었습니다!!");


                        ad42.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad42.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad42.show();

                    }
                });
                ck42.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck42.show();


            }
        });
        btn_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck43 = new AlertDialog.Builder(PlayActivity.this);
                ck43.setMessage("이 상자를 선택하시겠습니까?");
                ck43.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_43_txt = (num[p] + "p");
                        btn_43.setText(btn_43_txt);
                        btn_43.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_43_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad43 = new AlertDialog.Builder(PlayActivity.this);
                        ad43.setMessage(btn_43_txt + "포인트가 당첨 되었습니다!!");


                        ad43.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad43.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad43.show();

                    }
                });
                ck43.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck43.show();


            }
        });
        btn_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck44 = new AlertDialog.Builder(PlayActivity.this);
                ck44.setMessage("이 상자를 선택하시겠습니까?");
                ck44.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_44_txt = (num[p] + "p");
                        btn_44.setText(btn_44_txt);
                        btn_44.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_44_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad44 = new AlertDialog.Builder(PlayActivity.this);
                        ad44.setMessage(btn_44_txt + "포인트가 당첨 되었습니다!!");


                        ad44.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad44.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad44.show();

                    }
                });
                ck44.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck44.show();


            }
        });
        btn_45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck45 = new AlertDialog.Builder(PlayActivity.this);
                ck45.setMessage("이 상자를 선택하시겠습니까?");
                ck45.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_45_txt = (num[p] + "p");
                        btn_45.setText(btn_45_txt);
                        btn_45.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_45_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad45 = new AlertDialog.Builder(PlayActivity.this);
                        ad45.setMessage(btn_45_txt + "포인트가 당첨 되었습니다!!");


                        ad45.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad45.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad45.show();

                    }
                });
                ck45.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck45.show();


            }
        });
        btn_46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck46 = new AlertDialog.Builder(PlayActivity.this);
                ck46.setMessage("이 상자를 선택하시겠습니까?");
                ck46.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_46_txt = (num[p] + "p");
                        btn_46.setText(btn_46_txt);
                        btn_46.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_46_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad46 = new AlertDialog.Builder(PlayActivity.this);
                        ad46.setMessage(btn_46_txt + "포인트가 당첨 되었습니다!!");


                        ad46.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad46.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad46.show();

                    }
                });
                ck46.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck46.show();


            }
        });
        btn_47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck47 = new AlertDialog.Builder(PlayActivity.this);
                ck47.setMessage("이 상자를 선택하시겠습니까?");
                ck47.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_47_txt = (num[p] + "p");
                        btn_47.setText(btn_47_txt);
                        btn_47.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_47_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad47 = new AlertDialog.Builder(PlayActivity.this);
                        ad47.setMessage(btn_47_txt + "포인트가 당첨 되었습니다!!");


                        ad47.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad47.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad47.show();

                    }
                });
                ck47.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck47.show();


            }
        });
        btn_48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck48 = new AlertDialog.Builder(PlayActivity.this);
                ck48.setMessage("이 상자를 선택하시겠습니까?");
                ck48.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_48_txt = (num[p] + "p");
                        btn_48.setText(btn_48_txt);
                        btn_48.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_48_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad48 = new AlertDialog.Builder(PlayActivity.this);
                        ad48.setMessage(btn_48_txt + "포인트가 당첨 되었습니다!!");


                        ad48.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad48.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad48.show();

                    }
                });
                ck48.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck48.show();


            }
        });
        btn_49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck49 = new AlertDialog.Builder(PlayActivity.this);
                ck49.setMessage("이 상자를 선택하시겠습니까?");
                ck49.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_49_txt = (num[p] + "p");
                        btn_49.setText(btn_49_txt);
                        btn_49.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_49_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad49 = new AlertDialog.Builder(PlayActivity.this);
                        ad49.setMessage(btn_49_txt + "포인트가 당첨 되었습니다!!");


                        ad49.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad49.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad49.show();

                    }
                });
                ck49.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck49.show();


            }
        });
        btn_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder ck50 = new AlertDialog.Builder(PlayActivity.this);
                ck50.setMessage("이 상자를 선택하시겠습니까?");
                ck50.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int p = rnd_Num.nextInt(15);
                        final String btn_50_txt = (num[p] + "p");
                        btn_50.setText(btn_50_txt);
                        btn_50.setEnabled(false);


                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CheckContract.CheckEntry.COLUMN_NAME_TITLE, btn_50_txt);

                        SQLiteDatabase db = CheckDbHelper.getInstance(getApplicationContext()).getWritableDatabase();
                        db.insert(CheckContract.CheckEntry.TABLE_NAME, null, contentValues);


                        AlertDialog.Builder ad50 = new AlertDialog.Builder(PlayActivity.this);
                        ad50.setMessage(btn_50_txt + "포인트가 당첨 되었습니다!!");


                        ad50.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        ad50.setNegativeButton("적립 내역 확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(PlayActivity.this, Check.class);
                                startActivity(intent);

                            }
                        });
                        ad50.show();

                    }
                });
                ck50.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ck50.show();


            }
        });


    }
}

















