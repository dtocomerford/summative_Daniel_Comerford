package com.example.dbinteractionpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class museumShop extends AppCompatActivity {

    ticket objTicket;
    museum objMuseum;
    ArrayList<product> itemsForSale = new ArrayList<product>();
    order objOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_shop);

        Button orderItemsButton = findViewById(R.id.orderItems);
        Button addToBasketBtn = findViewById(R.id.addbasketButton);
        EditText shirtQuantity = findViewById(R.id.shirtQuantity);
        EditText hatQuantity = findViewById(R.id.hatQuantity);
        EditText snowglobeQuantity = findViewById(R.id.snowGlobeQuantity);
        EditText keychainQuantity = findViewById(R.id.keychainQuantity);
        EditText bottleQuantity = findViewById(R.id.bottleQuantity);
        EditText mugQuantity = findViewById(R.id.mugQuantity);
        EditText coasterQuantity = findViewById(R.id.coasterQuantity);





        product shirt = new product("Shirt", 10);
        product hat = new product("Hat", 5);
        product snowGlobe = new product("Snow Globe", 5);
        product keyChain = new product("Key Chain", 5);
        product bottle = new product("Bottle", 5);
        product mug = new product("Mug", 5);
        product coaster = new product("Coaster", 2);

        itemsForSale.add(shirt);
        itemsForSale.add(hat);
        itemsForSale.add(snowGlobe);
        itemsForSale.add(keyChain);
        itemsForSale.add(bottle);
        itemsForSale.add(mug);
        itemsForSale.add(coaster);

        objOrder = new order();

        objOrder.basket.add(shirt);
        objOrder.basket.add(hat);
        objOrder.basket.add(snowGlobe);
        objOrder.basket.add(keyChain);
        objOrder.basket.add(bottle);
        objOrder.basket.add(mug);
        objOrder.basket.add(coaster);

        Intent intent = getIntent();
        objTicket  = (ticket) intent.getSerializableExtra("ticket");

        objOrder.museumTicket = objTicket;


        System.out.println("MUSEUM NAME: " + objTicket.name);
        System.out.println("TICKET COST: " + objTicket.cost);



        addToBasketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                objOrder.basket.get(0).quantity = Integer.parseInt(String.valueOf(shirtQuantity.getText()));
                objOrder.basket.get(1).quantity = Integer.parseInt(String.valueOf(hatQuantity.getText()));
                objOrder.basket.get(2).quantity = Integer.parseInt(String.valueOf(snowglobeQuantity.getText()));
                objOrder.basket.get(3).quantity = Integer.parseInt(String.valueOf(keychainQuantity.getText()));
                objOrder.basket.get(4).quantity = Integer.parseInt(String.valueOf(bottleQuantity.getText()));
                objOrder.basket.get(5).quantity = Integer.parseInt(String.valueOf(mugQuantity.getText()));
                objOrder.basket.get(6).quantity = Integer.parseInt(String.valueOf(coasterQuantity.getText()));

            }
        });

        orderItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                openPage(museumCafe.class, objOrder);


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