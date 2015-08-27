package hxk.convert;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * @author Administrator
 * @description 普通的监听器
 *2015-7-23  上午11:41:03
 */
public class EmailMessageListener implements MessageListener {  
    
    public void onMessage(Message message) {  
        System.out.println("enter");
        if (message instanceof ObjectMessage) {  
            ObjectMessage objMessage = (ObjectMessage) message;  
            try {  
                Object obj = objMessage.getObject();  
                Email email = (Email) obj;  
                System.out.println("接收到一个ObjectMessage，包含Email对象。");  
                System.out.println(email);  
            } catch (JMSException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
   
}  
