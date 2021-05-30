package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@SpringBootApplication
@EnableEurekaClient
@Hystrix
public class update {
	
	public static void main(String[] args) {
		SpringApplication.run(update.class, args);
	}

}
