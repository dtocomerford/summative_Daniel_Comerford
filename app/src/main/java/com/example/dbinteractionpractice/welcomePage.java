package com.example.dbinteractionpractice;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class welcomePage extends AppCompatActivity
{

    adapter objAdapter;
    ArrayList<museum> museumList = new ArrayList<museum>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);


        //Intent intent = getIntent();

        putTableDataToObjects();
        listMuseums();
    }

    public void listMuseums()
    {
        Context context = this;


        RecyclerView recyclerObj = findViewById(R.id.recyclerID);
        recyclerObj.setLayoutManager(new LinearLayoutManager(context));
        objAdapter = new adapter(context, (museumList));
        recyclerObj.setAdapter(objAdapter);
    }

    public void putTableDataToObjects()
    {
        String listOfMuseums;
        utility objUtility = new utility();
        museumDatabase objMuseumDB = new museumDatabase(this, null, null, 1);
        //int tableSize = (int) objMuseumDB.getTableSize();
        listOfMuseums = objMuseumDB.getMuseum(10);
        museumList = objUtility.formatData(listOfMuseums, 6);
    }
}
