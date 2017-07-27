/**
 * 
 */
package com.login.Util;

import org.quartz.SchedulerException;

/**
 * @author Administrator
 *
 */
public interface QuartzService {

	
	public void createQuartzTask() throws SchedulerException;
	
}
