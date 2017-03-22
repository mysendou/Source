package com.aug.jma.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class CStopEventHandler implements
        ApplicationListener<ContextStoppedEvent> {

    /**
     * 当使用 ConfigurableApplicationContext 接口中的 stop() 方法停止 ApplicationContext
     * 时，发布这个事件。
     */
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("Execute CStopEventHandler onApplicationEvent method");
    }

}
