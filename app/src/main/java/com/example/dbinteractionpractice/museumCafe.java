package com.example.dbinteractionpractice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class museumCafe extends AppCompatActivity {

    order objOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_cafe);

        Intent intent = getIntent();
        objOrder  = (order) intent.getSerializableExtra("order");

        Button addToBasketButton = findViewById(R.id.addFoodToBasket);
        Button orderFoodButton = findViewById(R.id.orderFood);
        EditText teaQuantity = findViewById(R.id.teaQuantity);
        EditText waterQuantity = findViewById(R.id.waterQuantity);
        EditText coffeeQuantity = findViewById(R.id.coffeeQuantity);
        EditText flatbreadQuantity = findViewById(R.id.flatbreadQuantity);
        EditText sandwichQuantity = findViewById(R.id.sandwichQuantity);
        EditText sweetrollQuantity = findViewById(R.id.sweatrollQuantity);
        EditText saladQuantity = findViewById(R.id.saladQuantity);

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


        addToBasketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                objOrder.basket.get(7).quantity = Integer.parseInt(String.valueOf(teaQuantity.getText()));
                objOrder.basket.get(8).quantity = Integer.parseInt(String.valueOf(waterQuantity.getText()));
                objOrder.basket.get(9).quantity = Integer.parseInt(String.valueOf(coffeeQuantity.getText()));
                objOrder.basket.get(10).quantity = Integer.parseInt(String.valueOf(flatbreadQuantity.getText()));
                objOrder.basket.get(11).quantity = Integer.parseInt(String.valueOf(sandwichQuantity.getText()));
                objOrder.basket.get(12).quantity = Integer.parseInt(String.valueOf(sweetrollQuantity.getText()));
                objOrder.basket.get(13).quantity = Integer.parseInt(String.valueOf(saladQuantity.getText()));
            }
        });

        orderFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openPage(receiptPage.class, objOrder);

            }
        });

    }

    public <T extends AppCompatActivity> void openPage(Class<T> page, order _order)
    {
        Intent intent = new Intent(this, page);
        intent.putExtra("order", _order);
        this.startActivity(intent);
    }
}