package com.my.myapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {
    public static final String CREATE_USER = "create table User ("
            + "id integer primary key autoincrement, "
            + "username text, "
            + "userpwd text)";
    public Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name,factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        //创建用户表
        db.execSQL(CREATE_USER);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //更新用户表
    }

}
