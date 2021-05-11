package com.example.dbinteractionpractice;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class museumCafe extends AppCompatActivity {

    order objOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_cafe);

        Intent intent = getIntent();
        objOrder  = (order) intent.getSerializableExtra("order");



        product tea = new product("Tea", 1);
        product water = new product("Water", 1);
        product coffee = new product("Coffee", 2);
        product flatbread = new product("Flatbread", 2);
        product sandwich = new product("Sandwich", 2);
        product sweetroll = new product("Sweet roll", 2);
        product salad = new product("Salad", 2);


        objOrder.basket.add(tea);
        objOrder.basket.add(water);
        objOrder.basket.add(coffee);
        objOrder.basket.add(flatbread);
        objOrder.basket.add(sandwich);
        objOrder.basket.add(sweetroll);
        objOrder.basket.add(salad);


        for(int i = 0; i < objOrder.basket.size(); i++)
        {
            System.out.println("name: " + objOrder.basket.get(i).name);
        }



    }
}