package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Insert {

	public static void main(String[] args) {
		SpringApplication.run(Insert.class, args);
		System.out.println("Insert App is called");
	}

}
