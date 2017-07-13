package com.lakana.util;

import com.lakana.filter.AppleFilter;
import com.lakana.module.Apple;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jeff.Ma on 1/6/2017.
 */
public class AppleUtil {
    /**
     * Get the green apples
     *
     * @param apples
     * @return
     */
    public static List<Apple> filterGreenApples (List<Apple> apples) {
        List<Apple> filterApples = new ArrayList<Apple>();
        for (final Apple apple : apples) {
            if (Color.GREEN.equals(apple.getColor())) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }

    /**
     * Get the red apples
     *
     * @param apples
     * @return
     */
    public static List<Apple> filterRedApples (List<Apple> apples) {
        List<Apple> filterApples = new ArrayList<Apple>();
        for (final Apple apple : apples) {
            if (Color.RED.equals(apple.getColor())) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }

    /**
     * Get the apples by color
     *
     * @param apples
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor (List<Apple> apples, Color color) {
        List<Apple> filterApples = new ArrayList<Apple>();
        for (final Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }

    /**
     * Filter apples by color and weight
     *
     * @param apples
     * @param color
     * @param weight
     * @return
     */
    public static List<Apple> filterApplesByColorAndWeight (List<Apple> apples, Color color, float weight) {
        List<Apple> filterApples = new ArrayList<Apple>();
        for (final Apple apple : apples) {
            if (color.equals(apple.getColor()) && apple.getWeight() >= weight) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }

    /**
     * Filter apples
     *
     * @param apples
     * @param appleFilter
     * @return
     */
    public static List<Apple> filterAppleByAppleFilter (List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> filterApples = new ArrayList<Apple>();
        for (final Apple apple : apples) {
            if (appleFilter.accept(apple)) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }
}
