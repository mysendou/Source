package com.lakana.methodreference.normal.test;

import com.lakana.methodreference.normal.Converter;
import com.lakana.methodreference.normal.Helper;

/**
 * Created by Jeff.Ma on 1/17/2017.
 * A method reference to an instance method of an existing object
 */
public class MethodReferenceTest2 {
    public static void main (String[] args) {
//        Converter<String, Integer> converter = new Converter<String, Integer>() {
//            @Override
//            public Integer convert (String from) {
//                return new Helper().string2Int(from);
//            }
//        };


        Helper helper = new Helper();
        Converter<String, Integer> converter = helper::string2Int;
        System.out.println("A method reference to an instance method");
        System.out.println(converter.convert("130"));

    }
}
