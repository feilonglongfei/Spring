package com.login.service;

import javax.jms.JMSException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml" })
public class JMSQueueSenderServiceTest {
	
	@Autowired
	JMSQueueSenderService jmsQueueSenderService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSendMessage() throws JMSException {
		jmsQueueSenderService.sendMessage();
	}
	
	@Test
	public void testSendMessageTopic() {
		jmsQueueSenderService.sendMessageTopic();
	}

}
