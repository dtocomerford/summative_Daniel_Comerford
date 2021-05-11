package com.example.dbinteractionpractice;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class museumDatabase extends SQLiteOpenHelper
{
    //museum table column names, database name and version
    private static final String DB_NAME = "Attractions.db";
    private static final int DB_VERSION = 1;
    private static final String MUSEUM_TABLE_Name = "MuseumAttractions";
    private static final String MUSEUM_COLUMN_ID = "MuseumID";
    private static final String MUSEUM_COLUMN_MuseumName = "MuseumName";
    private static final String MUSEUM_COLUMN_Country = "Country";
    private static final String MUSEUM_COLUMN_City = "City";
    private static final String MUSEUM_COLUMN_EntryFee = "EntryFee";
    private static final String MUSEUM_COLUMN_BriefDescription = "BriefDescription";
    private static final String MUSEUM_COLUMN_Description = "Description";




    public museumDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DB_NAME, factory, DB_VERSION);
    }



    //onCreate function called when the class is initialised
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //string of the sql query to create the museum table in SQLite
        String CREATE_museumTable = "CREATE TABLE " +
                MUSEUM_TABLE_Name + "(" +
                MUSEUM_COLUMN_ID + " INTEGER PRIMARY KEY," +
                MUSEUM_COLUMN_MuseumName + " TEXT," +
                MUSEUM_COLUMN_Country + " TEXT," +
                MUSEUM_COLUMN_City + " TEXT," +
                MUSEUM_COLUMN_EntryFee + " INTEGER," +
                MUSEUM_COLUMN_BriefDescription + " TEXT," +
                MUSEUM_COLUMN_Description + " TEXT" + ");";

        db.execSQL(CREATE_museumTable);


        //db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }



    public void addMuseum(String museumName, String country, String city, int entryFee, String bDescription, String description)
    {

        ContentValues values = new ContentValues();
        values.put(MUSEUM_COLUMN_MuseumName, museumName);
        values.put(MUSEUM_COLUMN_Country, country);
        values.put(MUSEUM_COLUMN_City, city);
        values.put(MUSEUM_COLUMN_EntryFee, entryFee);
        values.put(MUSEUM_COLUMN_BriefDescription, bDescription);
        values.put(MUSEUM_COLUMN_Description, description);

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(MUSEUM_TABLE_Name, null, values);
        db.close();

        System.out.println("Museum details in addMuseum " + museumName + " " + country + " " + city + " " +entryFee+ " " +bDescription+ " " + description);

    }




    public String getMuseum(int numOfEntries)
    {

        addMuseum("Louvre", "France", "Paris", 10, "World famous art gallery", "Spectacular architecture in then heart of Paris home to the world renown Mona Lisa");
        addMuseum("National Museum of China", "China", "Beijing", 10, "Chinese art history", "The museum's mission is to educate about the arts and history of China");
        addMuseum("Vatican Museums", "Vatican", "Vatican City", 10, "Capital of Christianity", "Home of the Pope and the centre of the faith Christianity");
        addMuseum("Metropolitan Museum of Art", "USA", "New York City", 10, "Famous art gallery in New York", "Largest art museum in the United States of America");
        addMuseum("British Museum", "England", "London", 10, "Located in Bloomsbury London", "Eight million works, a museum dedicated to human history, art and culture");
        addMuseum("Tate Modern", "England", "London", 5, "International modern art", "The museum is housed in an old power station");
        addMuseum("National Gallery", "England", "London", 5, "Based in Trafalgar Square", "Founded in 1824 the gallary contains over 2300 paintings from the 13th century to 1900");
        addMuseum("National History Museum", "England", "London", 10, "Large dinosaur skeleton", "One of the greatest museums in the world the National History Museum welcomes you to London and a journey into the past!");
        addMuseum("American Museum of Natural History", "USA", "New York City", 5, "Upper West Side of Manhattan", "Located in Theodore Roosevelt Park across the street from Central Park");
        addMuseum("State Hermitage Museum", "Russia", "Saint Petersburg", 5, "The second-largest art museum in the world", "The museum is now housed in five interconnected buildings now");


        String query = "Select * FROM " + MUSEUM_TABLE_Name;
        String reply = "";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);





        if(cursor != null)
        {
            cursor.moveToFirst();

            for(int i = 0; i< numOfEntries; i++)
            {
                cursor.moveToPosition(i);



                reply += cursor.getString(1) +"|"+
                        cursor.getString(2) +"|"+
                        cursor.getString(3) +"|"+
                        Double.parseDouble(cursor.getString(4)) +"|"+
                        cursor.getString(5) +"|"+
                        cursor.getString(6) +"|";
            }
        }else
        {
            System.out.println("Cursor empty");
        }

        cursor.close();
        db.close();
        return reply;
    }

    public long getTableSize()
    {
        //System.out.println(MUSEUM_TABLE_Name == null);
        SQLiteDatabase db = this.getWritableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, MUSEUM_TABLE_Name);
        db.close();
        return count;
    }

}

