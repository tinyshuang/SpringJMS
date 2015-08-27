package hxk.messageLister;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 
 * @author Administrator
 * @description 
 *2015-7-22  下午2:49:44
 */
public class AdapterSender {
    
    public static void main(String[] args) {
	
        @SuppressWarnings("resource")
	ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
        final Destination adapter = (Destination) ctx.getBean("adapterDestination");
       // final Destination response = (Destination) ctx.getBean("responseDestination");
        template.send(adapter, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
        	TextMessage message = session.createTextMessage("Send the message for the adapterQueue test");
        	//这里可以设置是否回复信息到MQ..或者直接在messageListenerAdapter配置回复的MQ
        	//message.setJMSReplyTo(response);
             return message;
            }
        });
        System.out.println("JMS Message Sent");
    }
}