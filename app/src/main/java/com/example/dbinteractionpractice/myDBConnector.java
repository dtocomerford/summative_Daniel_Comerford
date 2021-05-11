package com.example.dbinteractionpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class myDBConnector extends SQLiteOpenHelper
{
    //user table
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Registration.db";
    private static final String USER_TABLE_Users = "Users";
    private static final String USER_COLUMN_ID = "UsersID";
    private static final String USER_COLUMN_Name = "Name";
    private static final String USER_COLUMN_UserName = "UserName";
    private static final String USER_COLUMN_Password = "Password";



    public myDBConnector(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {


        String CREATE_userTable = "CREATE TABLE " +
                USER_TABLE_Users + "(" +
                USER_COLUMN_ID + " INTEGER PRIMARY KEY," +
                USER_COLUMN_Name + " TEXT, " +
                USER_COLUMN_UserName + " TEXT," +
                USER_COLUMN_Password + " INTEGER" + ");";


        db.execSQL(CREATE_userTable);

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }


    public void addNewUser(String name, String userName, String password)
    {
        ContentValues values = new ContentValues();
        values.put(USER_COLUMN_Name, name);
        values.put(USER_COLUMN_UserName, userName);
        values.put(USER_COLUMN_Password, password);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(USER_TABLE_Users, null, values);
        db.close();
    }



    public boolean checkLogin(String username, String password)
    {
        boolean result= false;

        String query = "Select * FROM " + USER_TABLE_Users + " WHERE " + USER_COLUMN_UserName + " = \"" + username + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            if(cursor.getString(3).equals(password))
            {
                result = true;
            }
        }else
        {
            result = false;
        }

        cursor.close();
        db.close();

        return result;
    }


    public String findUser(String Username)
    {
        String s = null;

        String query = "Select * FROM " + USER_TABLE_Users + " WHERE " + USER_COLUMN_UserName + " = \"" + Username + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            s = Integer.parseInt(cursor.getString(0)) +
                                cursor.getString(1) +
                                cursor.getString(2) +
                                cursor.getString(3);
        }

        cursor.close();
        db.close();

        return s;

    }


    /*
    public String findMuseum(String museumName)
    {
        String s = null;

        String query = "Select * FROM " + MUSEUM_TABLE_Museums + " WHERE " + MUSEUM_COLUMN_City + " = \"" + Username + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            s = Integer.parseInt(cursor.getString(0)) +
                    cursor.getString(1) +
                    cursor.getString(2) +
                    cursor.getString(3);
        }

        cursor.close();
        db.close();

        return s;

    }

     */

}
