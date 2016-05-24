package aug.jma.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent{

    public MyEvent(Object source) {
        super(source);
        System.out.println("Execute MyEvent MyEvent method");
    }

    @Override
    public String toString() {
        System.out.println("Execute MyEvent toString method");
        return "MyEvent toString method";
    }
}
