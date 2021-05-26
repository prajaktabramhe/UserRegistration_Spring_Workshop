package com.bridgelabz.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class UserRegistrationWorkshopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(UserRegistrationWorkshopApplication.class, args);
		log.info("User Registration started in {} environment..", context.getEnvironment().getProperty("environment"));
		log.info("User Registraiton DB User is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
