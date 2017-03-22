package com.aug.jeff.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * ObjectOutputStream/ObjectInputStream
 * 对子类对象进行反序列化的时候，如果父类没有实现序列化接口，那么父类的构造函数会被调用
 * 进行序列化
 * @author jeff
 *
 */
public class ObjectIO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sources/person.txt"));
//        Person p = new Person("jeff", 24);
//        oos.writeObject(p);
//        oos.flush();
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sources/person.txt"));
        Person p1 = (Person) ois.readObject();
        System.out.println(p1);
    }
}
