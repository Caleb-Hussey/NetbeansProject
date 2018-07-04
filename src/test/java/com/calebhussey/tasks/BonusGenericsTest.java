package com.calebhussey.tasks;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test to drive the development of the BonusGenerics class
 */
public class BonusGenericsTest {
    
    private final BonusGenerics generics;
    
    public BonusGenericsTest() {
        generics = new BonusGenerics();
    }

    @Test
    public void test() {
        String s = "1";
        Integer i = 1;
        s = generics.add(s, 1);
        assertEquals("2", s);
        s = generics.add(s, 5);
        assertEquals("7", s);
        i = generics.add(i, 2);
        assertEquals((Integer) 3, i);
        i = generics.add(i, 1);
        assertEquals((Integer) 4, i);
    }
    
}
