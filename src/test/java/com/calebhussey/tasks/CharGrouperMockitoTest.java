
package com.calebhussey.tasks;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.AdditionalMatchers.aryEq;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * Tests the group function in the class CharGrouper using Mockito
 */
public class CharGrouperMockitoTest {
    
    private final String specialInputString = "abcdef";
    private final String specialOutputString = "SUCCESS";
    private final int[] specialInput;
    private final int[] specialOutput;
    
    public CharGrouperMockitoTest(){
        specialInput = convertStringToIntArray(specialInputString);
        specialOutput = convertStringToIntArray(specialOutputString);
    }
    
    @Mock
    private ArraySorter arraySorterMock;
    
    @Spy
    private StringCompressor stringCompressorSpy;

    @Spy
    @InjectMocks
    private CharGrouper charGrouper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(arraySorterMock.sort(aryEq(specialInput))).thenReturn(specialOutput);
        when(arraySorterMock.sort(not(aryEq(specialInput)))).thenReturn(new int[0]);
    }

    @Test
    public void testSpecialBehavior() {
        
        String inputString = specialInputString;
        String result = charGrouper.group(inputString);
        String expectedResult = specialOutputString;
        
        assertEquals(result, expectedResult);
        verify(charGrouper).group(anyString());
    }
    
    @Test
    public void testGeneralBehavior() {
        
        String inputString = "abcdefg";
        String result = charGrouper.group(inputString);
        String expectedResult = "";
        
        assertEquals(result, expectedResult);
        verify(charGrouper, times(1)).group(anyString());
    }
    
    @Test
    public void testGeneralBehaviorSecond() {
        
        String inputString = "The Best String";
        String result = charGrouper.group(inputString);
        String expectedResult = "";
        
        assertEquals(result, expectedResult);
        verify(charGrouper).group(anyString());
        verify(stringCompressorSpy).compress(anyString());
    }
    
    private int[] convertStringToIntArray(String stringToConvert){
        char[] charArray = stringToConvert.toCharArray();
        int length = charArray.length;
        int[] arrayToReturn = new int[length];
        
        for (int k=0; k<length; k++){
            arrayToReturn[k] = (int)charArray[k];
        }
        
        return arrayToReturn;
    }

}
