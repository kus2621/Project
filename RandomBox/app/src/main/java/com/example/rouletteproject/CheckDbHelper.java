package com.example.rouletteproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CheckDbHelper extends SQLiteOpenHelper{

        private static CheckDbHelper sInstance;

        private static final int DB_VERSION = 1;
        private static final String  DB_NAME = "Memo.db";
        private static final String  SQL_CREATE_ENTRIES =
                String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT, %s TEXT)" ,
                        CheckContract.CheckEntry.TABLE_NAME,
                        CheckContract.CheckEntry._ID,
                        CheckContract.CheckEntry.COLUMN_NAME_TITLE,
                        CheckContract.CheckEntry.COLUMN_NAME_CONTENTS);

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + CheckContract.CheckEntry.TABLE_NAME;
        public static CheckDbHelper getInstance(Context context){

            if (sInstance == null) {
                sInstance = new CheckDbHelper(context);
            }
            return sInstance;
        }

        private CheckDbHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //최초의 db 생성하는 부분
            db.execSQL(SQL_CREATE_ENTRIES);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);

        }
}