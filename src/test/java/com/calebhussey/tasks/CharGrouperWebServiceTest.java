package com.calebhussey.tasks;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Launches the application and tests the web service
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CharGrouperWebServiceTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void exampleBehaviorTest() throws IOException {
        
        String inputString = "abzuaaissna";
        String expected = "a4bins2uz";
                
        ResponseEntity<String> responseEntity = getResponse(inputString);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        String result = responseEntity.getBody();
        assertEquals(expected, result);
    }
    
    private ResponseEntity<String> getResponse(String input){
        String url = "/group?input=" + input;
        return restTemplate.getForEntity(url, String.class);
    }
    
}
