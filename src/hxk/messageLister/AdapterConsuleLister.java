package hxk.messageLister;

/**
 * @author Administrator
 * @description 一个消息监听器来监听发送到adapterQueue的消息
 *2015-7-22  下午4:32:51
 */
public class AdapterConsuleLister {
    
    public void handleMessage(String message){
	System.out.println("进入默认的代理处理方法,消息为 : " + message);
    }
    
    
    public void recevie(String message){
	System.out.println("进入指定的代理处理方法,消息为  : " + message);
    }
    
    
    /** 
     * 当返回类型是非null时,MessageListenerAdapter会自动把返回值封装成一个Message，然后进行回复 
     * 所以过程是有一条消息发送到adapterQueue,
     * adapterQueue接收到信息之后,可以选择是否回复MQ..
     * 通过return的方式回复到了responseQueue去..
     * @param message 
     * @return 
     */  
    public String receiveMessage(String message) {  
        System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);  
        return "这是ConsumerListener对象的receiveMessage方法的返回值。";  
    }  
    
}
