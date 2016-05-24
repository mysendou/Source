package aug.jma.event.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import aug.jma.event.MyEvent;

public class MyEventPublisher implements ApplicationEventPublisherAware{

    private ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        System.out.println("Execute ApplicationEventPublisher setApplicationEventPublisher method");
        this.publisher = publisher;
    }
    
    public void publish(){
        System.out.println("Execute MyEventPublisher publish method");
        MyEvent myEvent = new MyEvent(this);
        publisher.publishEvent(myEvent);
    }

}
