package com.example.dbinteractionpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class museumPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_page);

        Intent intent = getIntent();
        museum objMuseum  = (museum) intent.getSerializableExtra("museum");

        TextView museumName = findViewById(R.id.museumShop);
        TextView museumDescription = findViewById(R.id.dateInput);
        ImageView museumPicture = findViewById(R.id.museumPicture);
        Button bookButton = findViewById(R.id.orderItems);
        museumName.setText(objMuseum.name);
        museumDescription.setText(objMuseum.description);



        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openPage(museumBookingPage.class, objMuseum);

            }
        });


        if(objMuseum.pictureNumber == 0)
        {
            museumPicture.setImageResource(R.drawable.lourve);
        }
        if(objMuseum.pictureNumber == 1)
        {
            museumPicture.setImageResource(R.drawable.museumchina);
        }
        if(objMuseum.pictureNumber == 2)
        {
            museumPicture.setImageResource(R.drawable.vaticanmuseum);
        }
        if(objMuseum.pictureNumber == 3)
        {
            museumPicture.setImageResource(R.drawable.metropolitanmuseum);
        }
        if(objMuseum.pictureNumber == 4)
        {
            museumPicture.setImageResource(R.drawable.britishmuseum);
        }
        if(objMuseum.pictureNumber == 5)
        {
            museumPicture.setImageResource(R.drawable.tatemodern);
        }
        if(objMuseum.pictureNumber == 6)
        {
            museumPicture.setImageResource(R.drawable.nationalgallery);
        }
        if(objMuseum.pictureNumber == 7)
        {
            museumPicture.setImageResource(R.drawable.nhm);
        }
        if(objMuseum.pictureNumber == 8)
        {
            museumPicture.setImageResource(R.drawable.americanmuseumnaturalhistory);
        }
        if(objMuseum.pictureNumber == 9)
        {
            museumPicture.setImageResource(R.drawable.statehermitage);
        }
    }

    public <T extends AppCompatActivity> void openPage(Class<T> page, museum objMuseum)
    {
        Intent intent = new Intent(this, page);
        intent.putExtra("museum", objMuseum);
        this.startActivity(intent);
    }


}