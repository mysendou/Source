package com.design.patterns.test;

import com.design.patterns.module.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Jeff.Ma on 3/8/2017.
 */
public class StreamVsCollection {
    public static final List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("fish", false, 450, Dish.Type.FISH));

    public static void main (String[] args) {
//        beforeJava8();
//        useJava8();
//        testStream();
//        useoreachTest();
//        useIteratorTest();
//        useStreamTest();
        streamOperation();
    }

    private static void streamOperation(){
        List<String> dishNames = menu.stream()
//                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .filter(dish -> {
                    System.out.println("filter:" + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("map:" + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(dishNames);
    }

    private static void useStreamTest(){
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);
    }

    private static void useIteratorTest(){
        List<String> dishNames = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        Dish dish = null;
        while (iterator.hasNext()){
            dish = iterator.next();
            dishNames.add(dish.getName());
        }
        System.out.println(dishNames);
    }

    private static void useoreachTest(){
        List<String> dishNames = new ArrayList<>();
        for (Dish dish: menu) {
            dishNames.add(dish.getName());
        }
        System.out.println(dishNames);
    }

    private static void testStream () {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }

    private static void useJava8 () {
        List<String> lowCaloricDishesName = menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(lowCaloricDishesName);
    }

    private static void beforeJava8 () {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        //Get the dish the calories less than 400
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        //base on the calories sort the dish that calories less than 400
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare (Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
        System.out.println(lowCaloricDishesName);
    }
}
