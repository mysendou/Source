package aug.jma.event.handler;

import org.springframework.context.ApplicationListener;

import aug.jma.event.MyEvent;

public class MyEventHandler implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("Execute MyEventHandler onApplicationEvent method");
        event.toString();
    }

}
