package com.taufikpirjade.dynamicscheduling;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * TaufikPirjade.info
 */

@Configuration
public class MyJob implements SchedulingConfigurer  {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		 //taskRegistrar.setScheduler(poolScheduler());
	     taskRegistrar.addTriggerTask(new Runnable() {
	            @Override
	            public void run() {
	                // Do not put @Scheduled annotation above this method, we don't need it anymore.
	               System.out.println("Running Schedular");
	            }
	        }, new Trigger() {
	            @Override
	            public Date nextExecutionTime(TriggerContext triggerContext) {
	                Calendar nextExecutionTime = new GregorianCalendar();
	                Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
	                nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
	                nextExecutionTime.add(Calendar.MILLISECOND, getNewExecutionTime());
	                return nextExecutionTime.getTime();
	            }
	        });
	}
	
	private int getNewExecutionTime() {
		//Load Your execution time from database or property file
		return 1000;
	}
	
	@Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        scheduler.setPoolSize(1);
        scheduler.initialize();
        return scheduler;
    }

}
