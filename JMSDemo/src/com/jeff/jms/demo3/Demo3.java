package com.jeff.jms.demo3;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 * Consumer1 get Message:1 Consumer2 get Message:2 Consumer1 get Message:3
 * Consumer2 get Message:4 Consumer1 get Message:5 Consumer2 get Message:6
 * Consumer1 get Message:7 Consumer2 get Message:8 Consumer1 get Message:9
 * Consumer2 get Message:10
 * 点对点的模型, 
 * @author Jeff.Ma
 * 
 */
public class Demo3 {
    public static void main(String[] args) throws Exception {
        // 创建工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");

        Connection connection = factory.createConnection();

        connection.start();

        // 创建一个Queue
        Queue queue = new ActiveMQQueue("testQueue");

        // 创建一个Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 注册消费者1
        MessageConsumer comsumer1 = session.createConsumer(queue);
        comsumer1.setMessageListener(new MessageListener() {
            public void onMessage(Message m) {
                try {
                    System.out.println("Consumer1 get " + ((TextMessage) m).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        // 注册消费者2
        MessageConsumer comsumer2 = session.createConsumer(queue);
        comsumer2.setMessageListener(new MessageListener() {
            public void onMessage(Message m) {
                try {
                    System.out.println("Consumer2 get " + ((TextMessage) m).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

        });

        // 创建一个生产者，然后发送多个消息。
        MessageProducer producer = session.createProducer(queue);
        for (int i = 0; i < 10; i++) {
            producer.send(session.createTextMessage("Message:" + (i + 1)));
        }
    }
}
