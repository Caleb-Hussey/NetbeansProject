package com.calebhussey.tasks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Contains bean definitions
 */
@Configuration
public class BeanConfiguration {
    
    @Bean
    public ArraySorter arraySorter(){
        return new ArraySorter();
    }
    
    @Bean
    public StringCompressor stringCompressor(){
        return new StringCompressor();
    }
    
    @Bean
    public CharGrouper charGrouper(){
        return new CharGrouper(arraySorter(), stringCompressor());
    }

}
