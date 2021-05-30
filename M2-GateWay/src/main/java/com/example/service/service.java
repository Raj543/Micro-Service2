package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Gateway;
import com.example.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class service {
	
	@Autowired
	public RestTemplate temp;
	
	@HystrixCommand(fallbackMethod ="err_addUser")
	public String addUser(User u)
	{
		Gateway.log.debug("--In Add User service ");
		String res = temp.getForObject("http://AddService:8091/add/"
				+ "sum/",String.class);
		System.out.println("Result:"+res);
		return res;
	}
	
	public String err_addUser(User u) {
		return "Issue while insertion, Insert App may be down";
	}
	
	@HystrixCommand(fallbackMethod ="err_getUser")
	
	public String fetchUser(User u)
	{
		Gateway.log.debug("--In get all User service ");
		String res = temp.getForObject("http://AddService:8091/add/"
				+ "sum/",String.class);
		System.out.println("Result:"+res);
		return res;
	}
	
	public String err_getUser(User u) {
		return "Issue while fetching, fetch App may be down";
	}
	
	@HystrixCommand(fallbackMethod ="err_delUser")
	public String delUser(int id)
	{
		Gateway.log.debug("--In del User service ");
		String res = temp.getForObject("http://AddService:8091/add/"
				+ "sum/",String.class);
		System.out.println("Result:"+res);
		return res;
	}
	
	public String err_delUser(int id) {
		return "Issue while deletion, deletion app may be down";
	}
	
	@HystrixCommand(fallbackMethod ="err_updateUser")
	public String updateUser(User u)
	{
		Gateway.log.debug("--In Update User service ");
		String res = temp.getForObject("http://AddService:8091/add/"
				+ "sum/",String.class);
		System.out.println("Result:"+res);
		return res;
	}
	
	public String err_updateUser(User u) {
		return "Issue while updatation, Update App may be down";
	}
}
