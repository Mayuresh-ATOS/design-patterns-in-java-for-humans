package com.pmareke.models;

import com.pmareke.interfaces.SortStrategy;

public class BubbleSortStrategy implements SortStrategy {
    @Override
    public int[] sort(int[] dataset) {
        System.out.println("Sorting using bubble sort");
        return dataset;
    }
}
