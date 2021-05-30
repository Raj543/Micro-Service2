package com.example.mCont;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.pojo.Person;
import com.example.pojo.User;

@Configuration
public class Temp {
	@Bean
	@LoadBalanced
	public RestTemplate getTemp() 
	{
		return new RestTemplate();
	}
	
	@Bean
	public Person getUser() {
		return new Person();
	}
}
