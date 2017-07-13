package com.lakana.methodreference.construct;

import com.lakana.methodreference.construct.factory.FactoryNoParameter;
import com.lakana.methodreference.construct.factory.FactoryOneParameter;
import com.lakana.methodreference.construct.factory.FactoryTwoParameter;
import com.lakana.methodreference.construct.module.Animal;
import com.lakana.methodreference.construct.module.Bird;
import com.lakana.methodreference.construct.module.Dog;

/**
 * Created by Jeff.Ma on 1/19/2017.
 */
public class Test2 {
    public static void main(String[] args){
        FactoryTwoParameter dogFactory2 = Dog::new;
        Animal dog2 = dogFactory2.create("alias", 3);
        FactoryTwoParameter birdFactory2 = Bird::new;
        Animal bird2 = birdFactory2.create("smook", 2);
        System.out.println(dog2);
        dog2.behavior();
        System.out.println(bird2);
        bird2.behavior();

        FactoryNoParameter factory = Dog::new;
        Animal dog = factory.create();
        System.out.println("====== no parameter=====");
        System.out.println(dog);

        FactoryOneParameter factoryOneParameter = Dog::new;
        Animal dog1 = factoryOneParameter.create("haha");
        System.out.println("====== one parameter =====");
        System.out.println(dog1);
    }
}
