package com.lakana.methodreference.construct.factory;

import com.lakana.methodreference.construct.module.Animal;

/**
 * Created by Jeff.Ma on 1/19/2017.
 */
public interface FactoryOneParameter<T extends Animal> {
    T create(String name);
}
