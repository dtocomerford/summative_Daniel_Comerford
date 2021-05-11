package com.example.dbinteractionpractice;

import java.io.Serializable;

public class product implements Serializable
{
    public String name;
    public double cost;
    public int quantity;


    public product(String _name, double _cost)
    {
        this.name = _name;
        this.cost = _cost;
    }


}


