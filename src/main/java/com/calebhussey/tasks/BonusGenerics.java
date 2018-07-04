package com.calebhussey.tasks;

/**
 * Contains a single method demonstrating generics
 */
public class BonusGenerics {
    
    public <T> T add(T a, int b){
        int firstInt;
        if (a instanceof String){
            firstInt = Integer.parseInt((String)a);
            return (T)((Object)(firstInt + b)).toString();
        } else {
            firstInt = (Integer)a;
            return (T)(Object)(firstInt + b);
        }
    }
    
}
