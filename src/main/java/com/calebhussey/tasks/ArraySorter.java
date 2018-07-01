package com.calebhussey.tasks;

import java.util.Arrays;

/**
 * Contains a method to sort int arrays.
 * 
 */
public class ArraySorter {
    
    /**
     * Returns a sorted copy of the provided unsorted array of ints.
     * @param unsorted an array of ints 
     * @return         a sorted copy of the provided unsorted int array
     */
    public int[] sort(int[] unsorted) {
        int[] copy = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(copy);
        return copy;
    }
    
}
