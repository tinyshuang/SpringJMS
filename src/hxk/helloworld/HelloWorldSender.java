package hxk.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 
 * @author Administrator
 * @description 最简单的JMS发送消息与接收消息
 *2015-7-22  下午2:49:44
 */
public class HelloWorldSender {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
	ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
        Destination destination = (Destination) ctx.getBean("destination");
        template.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
             return session.createTextMessage("Hello World,ActiveMQ Spring JMS Message！");
            }
        });
        System.out.println("JMS Message Sent");
    }
}