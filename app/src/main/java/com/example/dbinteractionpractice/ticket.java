package com.example.dbinteractionpractice;

import android.text.Editable;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class ticket extends AppCompatActivity implements Serializable
{
    public String name;
    public double cost;
    public String bookDate;
    public String timeSlot;
    public int quantity;

}
