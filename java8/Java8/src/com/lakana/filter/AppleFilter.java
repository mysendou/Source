package com.lakana.filter;

import com.lakana.module.Apple;

/**
 * Created by Jeff.Ma on 1/6/2017.
 * This interface is used to filter apple
 */
@FunctionalInterface
public interface AppleFilter {
    boolean accept (Apple apple);
}
