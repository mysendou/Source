package com.lakana.test;

import java.util.Arrays;

/**
 * Created by Jeff.Ma on 1/13/2017.
 * Test the Functional interfaces already available in the Java API
 */
public class TestFunctionalInterface {
    public static void main (String[] args) {
//        TestComparator();
        TestRunnable();
    }

    /**
     * Test Comparator
     */
    public static void TestComparator () {
        String[] words = {"Java", "Scala", "C++", "Haskell", "Lisp"};
        Arrays.sort(words, (first, second) -> Integer.compare(first.length(), second.length()));
        System.out.println(words);
    }

    /**
     * Test the Runable
     */
    public static void TestRunnable () {
        Runnable run1 = () -> System.out.println("runable1");
        Runnable run2 = () -> System.out.println("runable2");

        process(run1);
        process(run2);
        process(() -> System.out.println("runable3"));
    }

    public static void process (Runnable r) {
        r.run();
    }

}
