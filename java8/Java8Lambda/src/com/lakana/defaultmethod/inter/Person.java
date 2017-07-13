package com.lakana.defaultmethod.inter;

/**
 * Created by Jeff.Ma on 1/19/2017.
 */
public interface Person {
    long getId();
    default String getName(){
        return "Jeff";
    }
}
