package com.peoplepowerco.virtuoso.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author : James Cho
 * @brief : Notification message SQLiteOpenHelper
 * @date : 2017. 8. 16.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPNotificationDBHelper extends SQLiteOpenHelper {

    public PPNotificationDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void createTable(SQLiteDatabase db) {
        String sql = "CREATE TABLE notification (_id INTEGER PRIMARY KEY AUTOINCREMENT, message TEXT, date TEXT, time TEXT);";
        try {
            db.execSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String message, String date, String time){
        SQLiteDatabase writableDB = getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            values.put("message", message);
            values.put("date", date);
            values.put("time", time);
            writableDB.insert("notification", null, values);
            writableDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String time){
        SQLiteDatabase writableDB = getWritableDatabase();
        String sql = "DELETE FROM notification WHERE time='" + time + "';";
        try {
            writableDB.execSQL(sql);
            writableDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAll(){
        SQLiteDatabase writableDB = getWritableDatabase();
        String sql = "DELETE FROM notification;";
        try {
            writableDB.execSQL(sql);
            writableDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SQLiteDatabase getDB(){
        SQLiteDatabase db = getReadableDatabase();
        return db;
    }
}
