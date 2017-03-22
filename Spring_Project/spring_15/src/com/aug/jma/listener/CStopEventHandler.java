package com.aug.jma.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class CStopEventHandler implements
        ApplicationListener<ContextStoppedEvent> {

    /**
     * ��ʹ�� ConfigurableApplicationContext �ӿ��е� stop() ����ֹͣ ApplicationContext
     * ʱ����������¼���
     */
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("Execute CStopEventHandler onApplicationEvent method");
    }

}
