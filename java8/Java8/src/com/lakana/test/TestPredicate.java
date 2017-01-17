package com.lakana.test;

import com.lakana.filter.PredicateFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Jeff.Ma on 1/6/2017.
 */
public class TestPredicate<T> {
    public static <T> List<T> filter (List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<T>();
        for (final T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }
        return newList;
    }

    public static void main (String[] args) {
        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
        List<String> list = new ArrayList();
        list.add("aaa");
        list.add(null);
        list.add("bbb");
        list.add("");
        list.add("ccc");

        List list1 = filter(list, (String str) -> null != str && !str.isEmpty());
        System.out.println(list1);
    }
}
