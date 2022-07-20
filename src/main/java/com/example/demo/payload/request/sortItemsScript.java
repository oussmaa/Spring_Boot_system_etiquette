package com.example.demo.payload.request;

import com.example.demo.Entity.Scripts;

import java.util.Comparator;

public class sortItemsScript implements Comparator<Scripts> {

    // Method of this class
    // @Override
    public int compare(Scripts a, Scripts b)
    {

        // Returning the value after comparing the objects
        // this will sort the data in Ascending order
        return a.getGenerated().compareTo(b.getGenerated());
    }
}