package com.calebhussey.tasks;

import org.springframework.stereotype.Service;

/**
 * Contains a function to compress strings
 */
@Service
public class StringCompressor {
    
    /**
     * Returns a compressed representation of the input String
     * 
     * @param uncompressed a string to be compressed
     * @return             a compressed representation of the input parameter
     */
    public String compress(String uncompressed) {
        
        //stringBuilder builds the compressed String
        StringBuilder stringBuilder = new StringBuilder();
        int uncompressedLength = uncompressed.length();
        int index = 0;
        
        //Compress each constant block of characters.
        while (index < uncompressedLength){
            index = compressNextConstantBlock(
                    uncompressed, 
                    uncompressedLength, 
                    index, 
                    stringBuilder
            );
        }
        String compressed = stringBuilder.toString();
        
        //Only return the compressed String if it is shorter than
        //the uncompressed String.
        if (compressed.length() == uncompressedLength){
            return uncompressed;
        } else {
            return compressed;
        }
        
    }

    private int compressNextConstantBlock(
            String uncompressed, 
            int uncompressedLength, 
            int index, 
            StringBuilder stringBuilder)
    {
        int lengthOfBlock = findLengthOfNextConstantBlock(
                uncompressed,
                uncompressedLength,
                index
        );
        stringBuilder.append(uncompressed.charAt(index));
        if (lengthOfBlock > 1){
            stringBuilder.append(lengthOfBlock);
        }
        return index + lengthOfBlock;
    }
    
    private int findLengthOfNextConstantBlock(
            String uncompressed, 
            int uncompressedLength, 
            int startingIndex)
    {
        int lengthOfBlock = 1;
        char firstCharacter = uncompressed.charAt(startingIndex);
        for (int testIndex = startingIndex+1; testIndex < uncompressedLength; testIndex++){
            char nextCharacter = uncompressed.charAt(testIndex);
            if (firstCharacter == nextCharacter){
                lengthOfBlock++;
            } else {
                return lengthOfBlock;
            }
        }
        
        return lengthOfBlock;
    }
    
}
