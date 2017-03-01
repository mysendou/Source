package com.lakana.methodreference.normal.test;

import com.lakana.methodreference.normal.ICompare;

/**
 * Created by Jeff.Ma on 1/17/2017.\
 * A method reference to an instance method
 */
public class MethodReferenceTest3 {
    public static void main (String[] args) {
//        ICompare iCompare = new ICompare() {
//            @Override
//            public boolean test (String first, String second) {
//                return first.equals(second);
//            }
//        };
        System.out.println("A method reference to an instance method");
        ICompare iCompare = String::equals;
        System.out.println(iCompare.test("abc", "abc"));//"abc".equals("abc")
    }
}
