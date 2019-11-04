package com.example.rouletteproject;

import android.provider.BaseColumns;

public final class CheckContract {

    private CheckContract(){


    }

    public static class CheckEntry implements BaseColumns{

        public static final String TABLE_NAME = "memo";
        public static final String  COLUMN_NAME_CONTENTS = "contents";
        public static final String COLUMN_NAME_TITLE = "title";

    }
}
