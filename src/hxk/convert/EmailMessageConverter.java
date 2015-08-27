package hxk.convert;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * @author Administrator
 * @description JMS消息与java之间的转换器
 *2015-7-23  上午11:39:04
 */
public class EmailMessageConverter implements MessageConverter {  
    
    public Message toMessage(Object object, Session session)  
            throws JMSException, MessageConversionException {  
        return session.createObjectMessage((Serializable) object);  
    }  
   
    public Object fromMessage(Message message) throws JMSException,  
            MessageConversionException {  
        ObjectMessage objMessage = (ObjectMessage) message;  
        return objMessage.getObject();  
    }  
   
}  
