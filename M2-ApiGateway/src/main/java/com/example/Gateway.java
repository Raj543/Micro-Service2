package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class Gateway {
	public static final Logger log = 
			LoggerFactory.getLogger(Gateway.class);

	public static void main(String[] args) {
		SpringApplication.run(Gateway.class, args);
	}

}
