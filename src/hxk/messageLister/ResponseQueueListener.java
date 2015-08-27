package hxk.messageLister;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Administrator
 * @description
 *2015-7-23  上午10:38:52
 */
public class ResponseQueueListener implements MessageListener {  
    public void onMessage(Message message) {  
        if (message instanceof TextMessage) {  
            TextMessage textMessage = (TextMessage) message;  
            try {  
                System.out.println("接收到发送到responseQueue的一个文本消息，内容是：" + textMessage.getText());  
            } catch (JMSException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  