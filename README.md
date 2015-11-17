# SpringJMS

###ActiveMQ安装 : http://pan.baidu.com/s/1kTMSy0J   

1.下载：http://activemq.apache.org/download.html 最新Windows版本  

2.配置jdk环境,解压ActiveMQ到本地  

3.启动ActiveMQ服务器：  

     1.32位机 : 直接运行\bin\win32\activemq.bat  
     
     2.64位机 : 直接运行\bin\win64\activemq.bat  
     
4.打开ActiveMQ消息管理后台系统 http://localhost:8161/admin/  




参考文章为 :   

HelloWorld : http://blog.csdn.net/baggio7095586/article/details/5708519

进阶                      :http://haohaoxuexi.iteye.com/blog/1893038  


helloworld阶段 : 一个发送消息的程序,一个接收消息的程序..实现最简单的JMS交流...  



###监听器阶段 :

	⑴MessageListener,最简单的监听器..只是拿来监听接收信息的
	⑵SessionAwareMessageListener,有个session的参数..可以拿来对接收到的信息再做响应..
	⑶MessageListenerAdapter,将消息委托交给一个普通的java类来处理..
	

###转化器阶段 :  

	实现MessageConverter接口来转换JMS对象与java对象..
	其实在使用MessageListenerAdapter时,Spring默认为我们提供了SimpleMessageConverter转换器..
	
###事务(无代码):  

	在Spring整合JMS的应用中，如果我们要进行本地的事务管理的话非常简单，只需要在定义对应的消息监听容器时指定其sessionTransacted属性为true，如：  
	
	`<bean id="jmsContainer"  class="org.springframework.jms.listener.DefaultMessageListenerContainer">  
	    <property name="connectionFactory" ref="connectionFactory" />  
	    <property name="destination" ref="queueDestination" />  
	    <property name="messageListener" ref="consumerMessageListener" />  
	    <property name="sessionTransacted" value="true"/>  
	</bean>`  
	

	该属性值默认为false，这样JMS在进行消息监听的时候就会进行事务控制，当在接收消息时监听器执行失败时JMS就会对接收到的消息进行回滚，对于SessionAwareMessageListener在接收到消息后发送一个返回消息时也处于同一事务下，但是对于其他操作如数据库访问等将不属于该事务控制。

	数据库跟JMS挂钩的事务先别理..

	
