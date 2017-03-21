package com.lakana.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Jeff.Ma on 1/13/2017.
 */
public class TestConsumer {
    public static void main (String[] args) {
        forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> {i = i + 1; System.out.println(i);});
    }

    public static <T> void forEach (List<T> list, Consumer<T> consumer) {
        for (T i : list) {
            consumer.accept(i);
        }
    }
}
