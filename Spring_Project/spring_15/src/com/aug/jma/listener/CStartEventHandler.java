package com.aug.jma.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CStartEventHandler implements
        ApplicationListener<ContextStartedEvent> {

    /**
     * ��ʹ�� ConfigurableApplicationContext �ӿ��е� start() �������� ApplicationContext
     * ʱ�����¼���������
     */
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("Execute CStartEventHandler onApplicationEvent method");
    }

}
