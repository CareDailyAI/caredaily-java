package com.peoplepowerco.virtuoso.sqlite;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import com.peoplepowerco.virtuoso.sqlite.JSON.JSONColumn;

import java.util.HashMap;

public class JSONContentProvider extends ContentProvider {

    private static final String DATABASE_NAME = "family_json_content.db";
    private static final String TABLE_NAME = "json";
    private static HashMap<String, String> sJsonProjectionMap;
    private DatabaseHelper mOpenHelper;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + JSONColumn._ID + " INTEGER  PRIMARY KEY,"
            + JSONColumn.URL + " TEXT NOT NULL UNIQUE,"
            + JSONColumn.JSON + " TEXT,"
            + JSONColumn.CREATED_TIME + " TEXT"
            + ");";

    static {
        sJsonProjectionMap = new HashMap<String, String>();
        sJsonProjectionMap.put(JSONColumn._ID, JSONColumn._ID);
        sJsonProjectionMap.put(JSONColumn.URL, JSONColumn.URL);
        sJsonProjectionMap.put(JSONColumn.JSON, JSONColumn.JSON);
        sJsonProjectionMap.put(JSONColumn.CREATED_TIME, JSONColumn.CREATED_TIME);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
        return JSONColumn.CONTENT_TYPE;
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        ContentValues values;
        if (initialValues != null) {
            values = new ContentValues(initialValues);
        } else {
            values = new ContentValues();
        }

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        long rowId = db.insert(TABLE_NAME, null, values);
        if (rowId > 0) {
            Uri recordUri = ContentUris.withAppendedId(JSONColumn.CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(recordUri, null);
            return recordUri;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_NAME);
        qb.setProjectionMap(sJsonProjectionMap);
        String orderBy;
        if (TextUtils.isEmpty(sortOrder)) {
            orderBy = JSONColumn.DEFAULT_SORT_ORDER;
        } else {
            orderBy = sortOrder;
        }
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, orderBy);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int count = db.update(TABLE_NAME, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int count = db.delete(TABLE_NAME, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

}