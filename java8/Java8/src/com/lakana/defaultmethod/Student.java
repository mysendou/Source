package com.lakana.defaultmethod;

import com.lakana.defaultmethod.inter.Named;
import com.lakana.defaultmethod.inter.Person;

/**
 * Created by Jeff.Ma on 1/19/2017.
 */
public class Student implements Person, Named{
    public String getName(){
        return Person.super.getName();
    }

    @Override
    public long getId () {
        return 0;
    }
}
