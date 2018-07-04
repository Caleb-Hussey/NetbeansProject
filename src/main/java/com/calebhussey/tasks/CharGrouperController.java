package com.calebhussey.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Exposes the class CharGrouper to HTTP Requests
 */
@Controller
public class CharGrouperController {
    
    private final CharGrouper charGrouper;
    
    @Autowired
    public CharGrouperController(CharGrouper charGrouper){
        this.charGrouper = charGrouper;
    }
    
    @GetMapping("/group")
    @ResponseBody
    public String callCharGrouper(@RequestParam(name="input", required=false, defaultValue="") String input){
        return charGrouper.group(input);
    }
    
}
