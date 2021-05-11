package com.example.dbinteractionpractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class utility
{
    public static ArrayList<museum> formatData(String stringToSplit, int columnsPerTable)
    {
        ArrayList<museum> museumList = new ArrayList<museum>();
        ArrayList<String> splitString = new ArrayList<>();


        String [] columnValues = stringToSplit.split("\\|");

        Collections.addAll(splitString, columnValues);


        for(int i =0; i <= splitString.size() -1; i+=6)
        {

            museum objMuesum = new museum();

            objMuesum.name = splitString.get(i);
            objMuesum.country = splitString.get(i+1);
            objMuesum.city = splitString.get(i+2);
            objMuesum.entryFee = Double.parseDouble(splitString.get(i+3));
            objMuesum.briefDescription = splitString.get(i+4);
            objMuesum.description = splitString.get(i+5);

            museumList.add(objMuesum);
        }

        for (museum muse: museumList)
        {
            System.out.println("Museum: " + muse.name);
            System.out.println("Museum country: " + muse.country);
            System.out.println("Museum city: " + muse.city);


        }


        return museumList;
    }
}
