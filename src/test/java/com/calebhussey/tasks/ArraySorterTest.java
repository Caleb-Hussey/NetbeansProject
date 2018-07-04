package com.calebhussey.tasks;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests the sort function in the class ArraySorter
 */
@RunWith(SpringRunner.class)
@Component
@ContextConfiguration(classes = BeanConfiguration.class)
public class ArraySorterTest {
    
    @Autowired
    private ArraySorter arraySorter;

    /**
     * Test the trivial case, where the array to be sorted is empty. 
     * 
     * This will confirm that no unexpected behavior occurs when attempting to 
     * sort an array with length 0.
     */
    @Test
    public void trivialTest() {
        int[] unsorted = new int[0];
        int[] expResult = new int[0];
        int[] result = arraySorter.sort(unsorted);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test whether the function sorts by numerical or by alphabetical order. 
     * 
     * The values in the unsorted array are all positive to exclude possible 
     * issues involving negative numbers. The values in the unsorted array are
     * chosen to be sorted differently according to numerical and alphabetical 
     * orders.
     */
    @Test
    public void confirmNumericalSortTest() {
        int[] unsorted = new int[]{2,10,1,3,4,100,20};
        int[] expResult = new int[]{1,2,3,4,10,20,100};
        int[] result = arraySorter.sort(unsorted);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test the case where the array contains both positive and negative values.
     * 
     * Be sure to include 0 in the array to be sorted. This will confirm that
     * the sort function handles negative numbers, positive numbers, and 0
     * as expected.
     */
    @Test
    public void mixedSignTest() {
        int[] unsorted = new int[]{111,-35,0,23,-9,-100,99,970};
        int[] expResult = new int[]{-100,-35,-9,0,23,99,111,970};
        int[] result = arraySorter.sort(unsorted);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test the case where the array contains some values more than once.
     * 
     * This will confirm that repeated values are handled as expected.
     */
    @Test
    public void repeatedValuesTest() {
        int[] unsorted = new int[]{1,33,1,0,33,-23,1,-23,1,0,-23};
        int[] expResult = new int[]{-23,-23,-23,0,0,1,1,1,1,33,33};
        int[] result = arraySorter.sort(unsorted);
        assertArrayEquals(expResult, result);
    }
    
}
