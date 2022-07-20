package com.example.demo.payload.request;

import com.example.demo.Entity.Scripts;
import com.example.demo.Entity.TestQA;

import java.util.Comparator;

public class sortItemsTest implements Comparator<TestQA> {

    // Method of this class
    // @Override
    public int compare(TestQA a, TestQA b)
    {

        // Returning the value after comparing the objects
        // this will sort the data in Ascending order
        return a.getGenerated().compareTo(b.getGenerated());
    }
}