package com.lakana.methodreference.inter;

/**
 * Created by Jeff.Ma on 1/17/2017.
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
