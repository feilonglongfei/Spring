package com.login.Util.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.login.Util.AspectAction;

@Service("AspectAction")
public class AspectActionImpl implements AspectAction {
	
	private static Logger logger = LoggerFactory.getLogger(AspectActionImpl.class);

	public void doBefore() {
		logger.info("AspectActionImpl.doBefore() be called");

	}

	public void doAfter() {
		logger.info("AspectActionImpl.doAfter() be called");

	}
	
	public void doAfterThrow(Throwable ex){
		logger.info("AspectActionImpl.doAfterThrow() be called...");
//		exception.printStackTrace();
//		ex.printStackTrace();
		logger.info(ex.getClass().getName());
		logger.info(ex.getMessage());
	}

}
