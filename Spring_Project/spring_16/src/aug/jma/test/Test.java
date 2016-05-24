package aug.jma.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aug.jma.event.publisher.MyEventPublisher;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MyEventPublisher myEventPublisher = (MyEventPublisher) context.getBean("myEventPublisher");
        myEventPublisher.publish();
//        myEventPublisher.publish();
        
    }

}
