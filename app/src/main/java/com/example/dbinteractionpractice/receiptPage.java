package com.example.dbinteractionpractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class receiptPage extends AppCompatActivity
{

    order objOrder;
    Button payButton;
    int moneyPaid;
    int total;
    double confirmationCode;
    int finalCode;
    Random rand;
    int minNum = 100000;
    int maxNum = 999999;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_page);

        Intent intent = getIntent();
        objOrder  = (order) intent.getSerializableExtra("order");
        AlertDialog.Builder msgBox = new AlertDialog.Builder(this);

        rand = new Random();
        confirmationCode = Math.floor(Math.random()*(maxNum-minNum+1)+minNum);
        finalCode = (int) confirmationCode;

        moneyPaid = 0;

        payButton = findViewById(R.id.payButton);
        EditText moneyInput = findViewById(R.id.moneyInput);
        TextView receiptText = findViewById(R.id.receiptText);
        TextView confirmationText = findViewById(R.id.confirmationText);

        receiptText.setText("Museum name: " + objOrder.museumTicket.name +
                        "\nMuseum booking date: " + objOrder.museumTicket.bookDate +
                        "\nMuseum time slot: " + objOrder.museumTicket.timeSlot +
                        "\nMuseum ticket quantity: " + objOrder.museumTicket.quantity);

        total = 0;



        for(int i =0; i<objOrder.basket.size(); i++)
        {
            if(objOrder.basket.get(i).quantity > 0)
            {
                total += (objOrder.basket.get(i).cost * objOrder.basket.get(i).quantity);
                receiptText.append("\nProduct name: " + objOrder.basket.get(i).name + "  " +
                        "Product quantity: " + objOrder.basket.get(i).quantity);
            }

        }

        total += objOrder.museumTicket.cost;
        receiptText.append("\n\n Total: £" + total);

        payButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                moneyPaid = Integer.parseInt(String.valueOf(moneyInput.getText()));

                if(moneyPaid >= total)
                {
                    confirmationText.setText("Total paid: " + total +"\n Confirmation code: " + finalCode);

                }

            }
        });
    }


}