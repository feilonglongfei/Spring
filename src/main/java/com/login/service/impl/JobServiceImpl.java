package com.login.service.impl;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import com.login.service.JobService;

@Service("JobService")
public class JobServiceImpl extends QuartzJobBean implements JobService {

	private static Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		logger.info("JobServiceImpl.executeInternal() be called.");
	}

	public void executeEveryMinute() {
		logger.info("JobServiceImpl.executeEveryMinute() be called at " + new Date().getTime());
	}

}
