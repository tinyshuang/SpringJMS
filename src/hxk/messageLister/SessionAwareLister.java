package hxk.messageLister;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

/**
 * @author Administrator
 * @description SessionAwareMessageListener消息监听器..
 * 	可以在接收到消息之后发送回复信息
 *2015-7-22  下午3:13:44
 */
public class SessionAwareLister implements SessionAwareMessageListener<TextMessage>{
    private Destination destination;
    
    @Override
    public void onMessage(TextMessage message, Session session) throws JMSException {
	//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
        TextMessage textMsg = (TextMessage) message;  
        System.out.println("SessionAware的队列接收到一个纯文本消息。");  
        try {  
            System.out.println("消息内容是：" + textMsg.getText());  
            System.out.println("开始回复消息");
            MessageProducer producer = session.createProducer(destination);
            Message answer = session.createTextMessage("I have revecied the SessionAware message");
            producer.send(answer);
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
    
    
}
