package com.lakana.test;

import com.lakana.filter.AppleFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Jeff.Ma on 1/13/2017.
 */
public class TestFunction {

    public static <T, R> List<R> filter(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<R>();
        for (final T t : list) {
            newList.add(function.apply(t));
        }
        return newList;
    }

    public static void main(String[] args){
          List<Integer> list = filter(Arrays.asList("lambads","in","action"), (String s) -> s.length());
        System.out.println(list);
    }
}
