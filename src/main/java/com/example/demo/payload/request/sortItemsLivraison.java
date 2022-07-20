package com.example.demo.payload.request;

import com.example.demo.Entity.Livraison;
import com.example.demo.Entity.TestQA;

import java.util.Comparator;

public class sortItemsLivraison implements Comparator<Livraison> {

    // Method of this class
    // @Override
    public int compare(Livraison a, Livraison b)
    {

        // Returning the value after comparing the objects
        // this will sort the data in Ascending order
        return a.getGenerated().compareTo(b.getGenerated());
    }
}