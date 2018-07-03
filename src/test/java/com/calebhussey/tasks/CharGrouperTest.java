package com.calebhussey.tasks;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the group function in the class CharGrouper
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Component
@ContextConfiguration(classes = BeanConfiguration.class)
public class CharGrouperTest {

    @Autowired
    private CharGrouper charGrouper;

    @Test
    public void exampleBehaviorTest() {
        String inputString = "abzuaaissna";
        String result = charGrouper.group(inputString);
        String expectedResult = "a4bins2uz";
        
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void noCompressionTest() {
        String inputString = "willow";
        String result = charGrouper.group(inputString);
        String expectedResult = "illoww";
        
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void trivialTest() {
        String inputString = "";
        String result = charGrouper.group(inputString);
        String expectedResult = "";
        
        assertEquals(result, expectedResult);
    }
    
    @Test
    public void multipleGroupingsTest() {
        String inputString = "eeefkeezaaaveecv";
        String result = charGrouper.group(inputString);
        String expectedResult = "a3ce7fkv2z";
        
        assertEquals(result, expectedResult);
    }
    
}
