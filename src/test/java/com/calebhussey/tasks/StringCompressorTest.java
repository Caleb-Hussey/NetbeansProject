package com.calebhussey.tasks;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests the compress function in the class StringCompressor
 */
@RunWith(SpringRunner.class)
@Component
@ContextConfiguration(classes = BeanConfiguration.class)
public class StringCompressorTest {
    
    @Autowired
    private StringCompressor stringCompressor;
    
    @Test
    public void compress_oneCharacter_shouldNotCompress() {
        String uncompressed = "a";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals("a", compressed);
    }
    
    @Test
    public void compress_moreCharacters_shouldCompress() {
        String uncompressed = "aaa";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals("a3", compressed);
    }
    
    @Test
    public void compress_repeatingSameCharacter_shouldCompressEachOccurenceIndependent() {
        String uncompressed = "aabbbbcaaddddddd";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals("a2b4ca2d7", compressed);
    }
    
    @Test
    public void compress_resultHasSameLengthAsInput_shouldNotCompress() {
        String uncompressed = "hello";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals(uncompressed, compressed);
    }
    
}
