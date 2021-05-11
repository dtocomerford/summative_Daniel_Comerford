package com.example.dbinteractionpractice;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class order implements Serializable
{
    ArrayList<product> basket = new ArrayList<product>();
    ticket museumTicket;
}
