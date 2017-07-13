package com.lakana.filter;

/**
 * Created by Jeff.Ma on 1/6/2017.
 */
@FunctionalInterface
public interface PredicateFilter<T> {
    boolean test(T t);
}
