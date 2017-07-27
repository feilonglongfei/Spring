package com.login.Util.impl;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.login.Util.QuartzService;

//@Service("QuartzService")
public class QuartzServiceImpl implements QuartzService {

	private static Logger logger = LoggerFactory.getLogger(QuartzServiceImpl.class);
	
	@Autowired
	SchedulerFactoryBean schedulerFactoryBean;
	
	@Autowired
	CronTriggerFactoryBean cronTriggerFactoryBean;
	
	@Autowired
	TaskExecutor taskExecutor;
	@Autowired
	StdSchedulerFactory stdSchedulerFactory;
	
	public void createQuartzTask() throws SchedulerException {
		
		stdSchedulerFactory.getScheduler();
		
		
//		System.out.println(schedulerFactoryBean.isSingleton());
//		Trigger triggers = null;
//		schedulerFactoryBean.setTriggers(triggers);
//		Trigger triggers = null;
//		Trigger setTriggers2 = null;
//		schedulerFactoryBean.setTriggers(triggers, setTriggers2);
		

		
	}
	
	

}
