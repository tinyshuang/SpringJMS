package hxk.messageLister;

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
 * @description 首先,
 * 		    destination ----> sessionAwareQueueDestination 的MQ信息
 * 		当sessionAwareQueueDestination接收到信息后 ,
 * 		   sessionAwareQueueDestination ----> destination 回复接收到信息
 *2015-7-22  下午2:49:44
 */
public class SessionAwareSender {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
	ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
        Destination destination = (Destination) ctx.getBean("sessionAwareQueueDestination");
        template.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
             return session.createTextMessage("Send the message for the SessionAwareQueue test");
            }
        });
        System.out.println("JMS Message Sent");
    }
}