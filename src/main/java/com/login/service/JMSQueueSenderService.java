/**
 * 
 */
package com.login.service;

import javax.jms.JMSException;

/**
 * @author Administrator
 *
 */
public interface JMSQueueSenderService {
	
	public void sendMessage() throws JMSException;
	
	public void sendMessageTopic();

}
