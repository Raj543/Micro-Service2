package com.example;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@SpringBootApplication
@EnableEurekaClient
@Hystrix
public class Delete {
	public static final org.slf4j.Logger log = LoggerFactory
			.getLogger(Delete.class);

	public static void main(String[] args) {
		SpringApplication.run(Delete.class, args);
		Delete.log.info("In main method");
	}

}
