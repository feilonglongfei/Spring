/**
 * 
 */
package com.login.service;

import javax.jms.Message;

/**
 * @author Administrator
 *
 */
public interface JMSServiceReceiver {

	public void onMessage(Message message);
}
