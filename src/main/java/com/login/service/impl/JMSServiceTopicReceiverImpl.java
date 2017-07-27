package com.login.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.login.service.JMSServiceTopicReceiver;

//@Service("JMSServiceTopicReceiver")
public class JMSServiceTopicReceiverImpl implements JMSServiceTopicReceiver {

	private static Logger logger = LoggerFactory.getLogger(JMSServiceTopicReceiverImpl.class);
	
	public void onMessage(Message message) {

		TextMessage tm = (TextMessage) message;
		try {
			logger.info("--------- JMSServiceTopicReceiverImpl.onMessage begin");
			logger.info(tm.getJMSMessageID().concat(" , ").concat(tm.getText()));
			logger.info(ToStringBuilder.reflectionToString(tm));
			logger.info("--------- JMSServiceTopicReceiverImpl.onMessage end");
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
