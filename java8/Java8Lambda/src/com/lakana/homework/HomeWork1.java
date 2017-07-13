package com.lakana.homework;

import com.lakana.module.Apple;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by Jeff.Ma on 2/28/2017.
 * <p>
 * HomeWork for 02/24/2017
 */
public class HomeWork1 {
    public static void main (String[] args) {
        System.out.println("==================");
        Apple apple1 = new Apple(1, Color.green, 100, "Good");
        Apple apple2 = new Apple(2, Color.green, 200, "Good");
        Apple apple3 = new Apple(3, Color.RED, 200, "Good");
        Apple apple4 = new Apple(4, Color.green, 400, "Good");
        Apple apple5 = new Apple(5, Color.RED, 300, "Good");
        Apple apple6 = new Apple(6, Color.green, 300, "Good");
        List<Apple> apples = new ArrayList<>();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
        apples.add(apple5);
        apples.add(apple6);
//        printApples(apples);
        List<Apple> list2 = printApplesUseLambda(apples, apple -> System.out.println(apple.getColor()));
    }

    public static List<Apple> printApples (List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
            for (Apple apple : inventory){
                System.out.println(apple.getColor());
            }
        return result;
    }

    public static List<Apple> printApplesUseLambda (List<Apple> inventory, Consumer<Apple> consumer) {
        List<Apple> result = new ArrayList<Apple>();
        for (final Apple apple : inventory){
            consumer.accept(apple);
        }
        return result;
    }
}
