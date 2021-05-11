package com.example.dbinteractionpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class museumBookingPage extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    ticket objTicket;
    EditText ticketQuantity;
    order objOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_booking_page);

        Intent intent = getIntent();
        museum objMuseum  = (museum) intent.getSerializableExtra("museum");


        objTicket = new ticket();
        CalendarView calendarView = findViewById(R.id.calendarView);

        radioGroup = findViewById(R.id.radioGroup);
        ticketQuantity = findViewById(R.id.ticketQuantity);
        Button bookMuseum = findViewById(R.id.orderItems);




        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                objTicket.bookDate = dayOfMonth + " " + month + " " + year;
                System.out.println("BOOK DATE: " + objTicket.bookDate);
            }
        });


        bookMuseum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                objTicket.timeSlot = (String) radioButton.getText();
                objTicket.quantity = Integer.parseInt(String.valueOf(ticketQuantity.getText()));
                objTicket.name = objMuseum.name;
                objTicket.cost = objMuseum.entryFee * Double.parseDouble(String.valueOf(ticketQuantity.getText()));


                openPage(museumShop.class, objTicket);
            }
        });



    }

    public void checkButton(View v)
    {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        objTicket.timeSlot = (String) radioButton.getText();
        System.out.println("Ticket time slot: " + objTicket.timeSlot);

    }

    // Allows passage of one page to another
    public <T extends AppCompatActivity> void openPage(Class<T> page, ticket _ticket)
    {
        Intent intent = new Intent(this, page);
        intent.putExtra("ticket", _ticket);
        this.startActivity(intent);
    }
}