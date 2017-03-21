package com.lakana.methodreference.construct;

import com.lakana.methodreference.construct.factory.FactoryTwoParameter;
import com.lakana.methodreference.construct.module.Animal;
import com.lakana.methodreference.construct.module.Bird;
import com.lakana.methodreference.construct.module.Dog;

/**
 * Created by Jeff.Ma on 1/19/2017.
 */
public class Test {
    public static void main (String[] args) {
        FactoryTwoParameter dogFactory = new FactoryTwoParameter() {
            @Override
            public Animal create (String name, int age) {
                return new Dog(name, age);
            }
        };
        Animal dog = dogFactory.create("alias", 3);

        FactoryTwoParameter birdFactory = new FactoryTwoParameter() {
            @Override
            public Animal create (String name, int age) {
                return new Bird(name, age);
            }
        };
        Animal bird = birdFactory.create("smook", 2);
        System.out.println(dog);
        dog.behavior();
        System.out.println(bird);
        bird.behavior();

    }
}
