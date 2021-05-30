package com.example.Cont;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class mTemp {
	@Bean
	public RestTemplate getTemp() {
		return new RestTemplate();
	}
}
