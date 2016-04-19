package com.aug.jma.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // 我们使用框架 API ClassPathXmlApplicationContext() 来创建应用程序的上下文。这个 API 加载
        // beans 的配置文件并最终基于所提供的 API，它处理创建并初始化所有的对象，即在配置文件中提到的 beans。
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 创建的上下文的 getBean() 方法来获得所需的 bean。这个方法使用 bean 的 ID
        // 返回一个最终可以转换为实际对象的通用对象。一旦有了对象，你就可以使用这个对象调用任何类的方法。
        //HelloWorld helloWorldA = (HelloWorld) context.getBean("hello");

//        helloWorldA.getMessage();

//        context.registerShutdownHook();
        // ((ClassPathXmlApplicationContext) context).close(); ///关闭应用上下文容器

         TextEditor te = (TextEditor) context.getBean("textEditor");
         te.spellCheck();
    }
}
