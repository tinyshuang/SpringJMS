package hxk.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;


/**
 * 
 * @author Administrator
 * @description 接收的情况目前有两种处理方式  
 * 		参考文章 : http://blog.csdn.net/baggio7095586/article/details/5708519
 * 		①以下这种直接使用while监听的方式..
 * 		②使用spring提供的监听器 :DefaultMessageListenerContainer去监听
 *2015-7-22  下午2:49:39
 */
public class HelloWorldReceiver {
    public static void main(String[] args) throws JMSException {
        @SuppressWarnings("resource")
	ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
        Destination destination = (Destination) ctx.getBean("destination");
        while (true) {
            TextMessage txtmsg = (TextMessage) template.receive(destination);
            if (null != txtmsg){
              System.out.println("Received Message: " + txtmsg.getText());
            }else{
                break;
            }
        }
    }
}