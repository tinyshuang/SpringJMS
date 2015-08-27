package hxk.messageLister;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Administrator
 * @description 最简单的消息监听器
 *2015-7-22  下午2:29:22
 */
public class HelloWorldLister implements MessageListener{

    @Override
    public void onMessage(Message message) {
	//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
        TextMessage textMsg = (TextMessage) message;  
        System.out.println("MessageListener接收到一个纯文本消息。");  
        try {  
            System.out.println("消息内容是：" + textMsg.getText());  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
    }

}
