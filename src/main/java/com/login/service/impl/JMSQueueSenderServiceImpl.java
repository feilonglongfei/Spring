/**
 * 
 */
package com.login.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.login.service.JMSQueueSenderService;

/**
 * @author Administrator
 *
 */
//@Service("JMSQueueSenderService")
public class JMSQueueSenderServiceImpl implements JMSQueueSenderService {

//	@Autowired
	@Resource(name="jmsTemplateQueue")
	private JmsTemplate jmsTemplateQueue;
	
	@Resource(name="jmsTemplateTopic")
	private JmsTemplate jmsTemplateTopic;
	
	@Autowired
	private ActiveMQQueue activeMQQueue;
	
//	@Autowired
//	ActiveMQConnectionFactory activeMQConnectionFactory;
	
	public void sendMessage() throws JMSException{
		
		MessageCreator messageCreator = new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				
				Message message = session.createTextMessage("this message from JMSQueueSenderImpl with queue model ...");
//				session.createMapMessage();
//				session.createObjectMessage();
//				session.createTextMessage();
//				message.setObjectProperty("name", new String("userName"));
//				return session.createTextMessage("this message from JMSQueueSenderImpl...");
				return message;
			}
		};
		
		jmsTemplateQueue.send(messageCreator);
	}
	
	public void sendMessageTopic() {
		MessageCreator messageCreator = new MessageCreator() {
		public Message createMessage(Session session) throws JMSException {
			
			Message message = session.createTextMessage("this message from JMSQueueSenderImpl with topic model ...");
//			session.createMapMessage();
//			session.createObjectMessage();
//			session.createTextMessage();
//			message.setObjectProperty("name", new String("userName"));
//			return session.createTextMessage("this message from JMSQueueSenderImpl...");
			message.setBooleanProperty("isVIPUser", true);
			message.setJMSPriority(9);
			return message;
			}
		};
		
		jmsTemplateTopic.send(messageCreator);
	}
}
