/**
 * 
 */
package com.login.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.login.service.JMSServiceReceiver;

/**
 * @author Administrator
 *
 */
//@Service("JMSServiceReceiver")
public class JMSServiceReceiverImpl implements JMSServiceReceiver, MessageListener {

	private static Logger logger = LoggerFactory.getLogger(JMSServiceReceiverImpl.class);

	public void onMessage(Message message) {
		
			//for queue model
			TextMessage tm = (TextMessage) message;
		
			try {
				logger.info("--------- JMSServiceReceiverImpl.onMessage begin");
				logger.info(tm.getJMSMessageID().concat(" , ").concat(tm.getText()));
				logger.info("--------- JMSServiceReceiverImpl.onMessage end");
			} catch (JMSException e) {
				e.printStackTrace();
			}
			
		
			
	}

}
