package com.example.eadfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLClientInfoException;

public class DBhelper extends SQLiteOpenHelper {

    public static final String DBNAME="LoginData.db";

    public DBhelper(Context context) {
        super(context,"LoginData.db",null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT,Fname TEXT, Lname TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password,String Fname,String Lname){
        SQLiteDatabase MyDB= this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("Fname",Fname);
        contentValues.put("Lname",Lname);
        long result = MyDB.insert("users",null,contentValues);
        if (result == 1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean checkUserName (String username){
        SQLiteDatabase MyDB= this.getReadableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username= ?",new String[]{username});
        if(cursor.getCount() > 0){
            return  true;
        }else{
            return false;
        }
    }

    public Boolean CheckUSernamePassword(String username, String password){
        System.out.println("Heree");
        SQLiteDatabase MyDB= this.getReadableDatabase();
        System.out.println(MyDB);
        Cursor cursor=MyDB.rawQuery("Select * from users where username= ? and password = ?",new String[]{username,password});
        if(cursor.getCount() > 0){
            return  true;
        }else{
            return false;
        }

    }

}
