package com.example.demo.payload.request;

import com.example.demo.Entity.Historique;
import com.example.demo.Entity.Livraison;

import java.util.Comparator;

public class sortItemsHistorique implements Comparator<Historique> {

    // Method of this class
    // @Override
    public int compare(Historique a, Historique b)
    {

        // Returning the value after comparing the objects
        // this will sort the data in Ascending order
        return a.getGenerated().compareTo(b.getGenerated());
    }
}