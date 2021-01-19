package com.example.farmstorelocator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "farmstore.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "credit";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_Amount = "amount";

    SQLiteDatabase db = this.getWritableDatabase();

    public Database (Context context) {super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    public void onCreate(SQLiteDatabase db){
        String SQl_CREATE_TABLE_CREDIT = "create table if not exists " + TABLE_NAME + "(" + COLUMN_ID + " Integer primary key autoincrement," + COLUMN_Amount + " blob not null);";
        db.execSQL(SQl_CREATE_TABLE_CREDIT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists credit");
        onCreate(db);
    }

    public Cursor getData (){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select amount from credit", null);
        return res;
    }

    public boolean insertCredit (Double amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("amount", amount);
        db.insert("credit", null, contentValues);
        return true;
    }

    public boolean updateContact (Double amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("amount", amount);
        db.update("credit", contentValues, COLUMN_Amount + "=" + amount,null);
        return true;
    }

}
