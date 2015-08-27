
package hxk.convert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * 
 * @author Administrator
 * @description
 *2015-7-22  下午2:49:44
 */
public class ConvertSender {
   private static ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
   private static JmsTemplate template = (JmsTemplate) ctx.getBean("convertJmsTemplate");
   private static Destination destination = (Destination) ctx.getBean("convertDestination");
   private static Email email = new Email("me", "test", "nothing");
   
   
   public static void main(String[] args) {
        //sendWithConvert();
        sendWithoutConvert();
    }
    
   /**
    * @description 不使用转换器的发送	
    *2015-7-23  下午12:11:35
    *返回类型:void
    */
    public static void sendWithoutConvert(){
        template.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
        	ObjectMessage message = session.createObjectMessage(email);
        	return message;
            }
        });
        System.out.println("JMS Message Sent");
    }
    
    /**
     * @description 使用转换器的发送	
     *2015-7-23  下午12:11:48
     *返回类型:void
     */
    public static void sendWithConvert(){
	template.convertAndSend(destination,email);
	System.out.println("JMS Message Sent");
    }
    
}