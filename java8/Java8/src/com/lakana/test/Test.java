package com.lakana.test;

import com.lakana.filter.AppleFilter;
import com.lakana.module.Apple;
import com.lakana.util.AppleUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff.Ma on 1/6/2017.
 */
public class Test {
    public static void main (String[] args) {
        Apple apple1 = new Apple(1, Color.green, 100, "Good");
        Apple apple2 = new Apple(2, Color.green, 200, "Good");
        Apple apple3 = new Apple(3, Color.RED, 200, "Good");
        Apple apple4 = new Apple(4, Color.green, 400, "Good");
        Apple apple5 = new Apple(5, Color.RED, 300, "Good");
        Apple apple6 = new Apple(6, Color.green, 300, "Good");

        List<Apple> apples = new ArrayList<Apple>();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
        apples.add(apple5);
        apples.add(apple6);

        int weight = 200;
        List<Apple> filterApples2 = AppleUtil.filterAppleByAppleFilter(apples, new AppleFilter() {
            @Override
            public boolean accept (Apple apple) {
                return Color.RED.equals(apple.getColor()) && apple.getWeight() > weight;
            }
        });
        System.out.println(filterApples2);

        System.out.println("=================== Using Lambda ================");
        //Use lambda.
        List<Apple> filterApples = AppleUtil.filterAppleByAppleFilter(apples,
                apple -> Color.RED.equals(apple.getColor()) && apple.getWeight() > weight);
        System.out.println(filterApples);

    }
}
