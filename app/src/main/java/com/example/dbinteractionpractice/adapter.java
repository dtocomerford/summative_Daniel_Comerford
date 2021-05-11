package com.example.dbinteractionpractice;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class adapter extends RecyclerView.Adapter<adapter.ViewHolder>
{

    private ArrayList<museum> myData;
    private LayoutInflater myInflater;
    ArrayList<String> keyList = new ArrayList<String>();
    Context context;


    // 01 constructor
    adapter(Context context, ArrayList<museum> data)
    {
        this.myInflater = LayoutInflater.from(context);
        this.myData = data;
        this.context = context;
        System.out.println("ADAPTER " + myData);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = myInflater.inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {


        holder.briefDescription.setText(myData.get(position).briefDescription + ". Country: " + myData.get(position).country + ". City: " + myData.get(position).city + ". Entry Fee: £" + myData.get(position).entryFee);
        holder.museumName.setText(myData.get(position).name);


        if(position == 0)
        {
            holder.museumPicture.setImageResource(R.drawable.lourve);
            myData.get(position).pictureNumber = position;

        }
        if(position == 1)
        {
            holder.museumPicture.setImageResource(R.drawable.museumchina);
            myData.get(position).pictureNumber = position;
        }
        if(position == 2)
        {
            holder.museumPicture.setImageResource(R.drawable.vaticanmuseum);
            myData.get(position).pictureNumber = position;
        }
        if(position == 3)
        {
            holder.museumPicture.setImageResource(R.drawable.metropolitanmuseum);
            myData.get(position).pictureNumber = position;
        }
        if(position == 4)
        {
            holder.museumPicture.setImageResource(R.drawable.britishmuseum);
            myData.get(position).pictureNumber = position;
        }
        if(position == 5)
        {
            holder.museumPicture.setImageResource(R.drawable.tatemodern);
            myData.get(position).pictureNumber = position;
        }
        if(position == 6)
        {
            holder.museumPicture.setImageResource(R.drawable.nationalgallery);
            myData.get(position).pictureNumber = position;
        }
        if(position == 7)
        {
            holder.museumPicture.setImageResource(R.drawable.nhm);
            myData.get(position).pictureNumber = position;
        }
        if(position == 8)
        {
            holder.museumPicture.setImageResource(R.drawable.americanmuseumnaturalhistory);
            myData.get(position).pictureNumber = position;
        }
        if(position == 9)
        {
            holder.museumPicture.setImageResource(R.drawable.statehermitage);
            myData.get(position).pictureNumber = position;
        }

        holder.moreInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openPage(museumPage.class, myData.get(position));
            }
        });
    }


    public <T extends AppCompatActivity> void openPage(Class<T> page, museum objMuseum)
    {
        Intent intent = new Intent(context, page);
        intent.putExtra("museum", objMuseum);
        context.startActivity(intent);
    }


    @Override
    public int getItemCount()
    {
        return myData.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView museumName;
        TextView briefDescription;
        ImageView museumPicture;
        Button moreInformation;

        ViewHolder(View v)
        {
            super(v);

            museumName = itemView.findViewById(R.id.museumShop);
            briefDescription = itemView.findViewById(R.id.dateInput);
            museumPicture = itemView.findViewById(R.id.museumPicture);
            moreInformation = itemView.findViewById(R.id.orderItems);

            //productName = itemView.findViewById(R.id.museumCity);
            //cost = itemView.findViewById(R.id.entryFee);
        }
    }


}
