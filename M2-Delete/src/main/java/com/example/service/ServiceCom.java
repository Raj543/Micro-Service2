package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCom {
	
	@Autowired
	public RestTemplate temp;
	
	/*@HystrixCommand(fallbackMethod = "errorList")
	public Person ser_List(int n) {
		Person p= temp.getForObject("http://list-service:8060/"
				+ "show/getById/"+n,Person.class);
		System.out.println("Res:"+p);
		return p;
	}
	
	public String errorlist(int n) {
		return "List-service looks to be down";
	}*/
}
