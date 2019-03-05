package com.taufikpirjade.dynamicscheduling;

/**
 * TaufikPirjade.info
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DynamicschedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicschedulingApplication.class, args);
	}

}
