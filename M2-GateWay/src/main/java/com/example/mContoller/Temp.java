package com.example.mContoller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Temp {
	
	@Bean
	@LoadBalanced
	public RestTemplate getTemp() {
		return new RestTemplate();
	}

}
