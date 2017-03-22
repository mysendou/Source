package com.aug.jma.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CStartEventHandler implements
        ApplicationListener<ContextStartedEvent> {

    /**
     * 当使用 ConfigurableApplicationContext 接口中的 start() 方法启动 ApplicationContext
     * 时，该事件被发布。
     */
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("Execute CStartEventHandler onApplicationEvent method");
    }

}
