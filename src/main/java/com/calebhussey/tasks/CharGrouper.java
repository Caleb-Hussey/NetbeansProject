package com.calebhussey.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Contains the functionality needed to sort the characters of a string and
 * then compress the resulting sorted string. Uses the functionality of
 * ArraySorter and StringCompressor
 */
@Service
public class CharGrouper {
    
    private final ArraySorter arraySorter;
    private final StringCompressor stringCompressor;
    
    /**
     * Constructor
     * 
     * Returns a new instance of CharGrouper for the povided 
     * ArraySorter and StringCompressor
     * 
     * @param arraySorter
     * @param stringCompressor
     */
    @Autowired
    public CharGrouper(
            ArraySorter arraySorter, 
            StringCompressor stringCompressor)
    {
        this.arraySorter = arraySorter;
        this.stringCompressor = stringCompressor;
    }
    
    /**
     * Sorts and compresses the provided ungrouped String.
     * 
     * @param ungrouped A String to be processed
     * @return          A sorted and compressed String
     */
    public String group(String ungrouped){
        
        String sortedString = sortString(ungrouped);
        String groupedResult = stringCompressor.compress(sortedString);
        return groupedResult;
    }

    private String sortString(String ungrouped) {
        int[] ungroupedIntArray = convertStringToIntArray(ungrouped);
        int[] sortedIntArray = arraySorter.sort(ungroupedIntArray);
        String sortedString = convertIntArrayToString(sortedIntArray);
        return sortedString;
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
    
    private String convertIntArrayToString(int[] arrayToConvert){
        int length = arrayToConvert.length;
        char[] charArray = new char[length];
        
        for (int k=0; k<length; k++){
            charArray[k] = (char)arrayToConvert[k];
        }
        return new String(charArray);
    }
    
}
