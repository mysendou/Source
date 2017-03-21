package com.lakana.methodreference.normal.test;

import com.lakana.methodreference.normal.Converter;

/**
 * Created by Jeff.Ma on 1/17/2017.
 * A method reference to a static method
 */
public class MethodReferenceTest {
    public static void main(String[] args){
//        Converter<String, Integer> converter = new Converter<String, Integer>() {
//            @Override
//            public Integer convert (String from) {
//                return MethodReferenceTest.string2Int(from);
//            }
//        };
        System.out.println("A method reference to a static method");
        Converter<String, Integer> converter = MethodReferenceTest::string2Int;
        System.out.println(converter.convert("120"));
    }
    static int string2Int(String from){
        return Integer.valueOf(from);
    }

}
