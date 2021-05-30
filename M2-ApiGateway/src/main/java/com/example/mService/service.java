package com.example.mService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Gateway;
import com.example.pojo.Person;
import com.example.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service(value="mService")
public class service {
	
	public service() {}

	@Autowired
	public RestTemplate temp;
	@Autowired
	public Person p;
	
	@HystrixCommand(fallbackMethod ="err_addPerson")
	public String  insertPerson(Person p)
	{	
		Gateway.log.warn("Call Insert service");
		System.out.println("Input  "+p);//localhost:Insert-service:8068
      /*String res = temp.getForObject("http://Delete-service:8064/delService/del/"+id,String.class);*/
		String res = temp.getForObject("http://Insert-service:8070/insertService/addPerson/"+p ,String.class);
		System.out.println("Insert res:"+res);
		return res;
	}
	
	public String err_addPerson(Person p) {
		return " Issue while insertion, Insert App may be down";
	}
	
	@HystrixCommand(fallbackMethod ="err_getPerson")
	public String fetchPerson(int id)
	{
		Gateway.log.warn("--In get Person service ");
		Person res = temp.getForObject("http://list-service:8060/show/getById/"
				+id,Person.class);
		System.out.println("Fetch result:"+res);
		return res.toString();
	}
	
	public String err_getPerson(int id) {
		return "Issue while fetching, fetch App may be down";
	}
	
	@HystrixCommand(fallbackMethod ="err_delPerson")
	public String delPerson(int id)
	{
		Gateway.log.warn("--In del Person service ");
		String res = temp.getForObject("http://Delete-service:8064"
				+ "/delService/del/"+id,String.class);
		System.out.println("Result:"+res);
		return res;
	}
	
	public String err_delPerson(int id) {
		return "Issue while deletion, deletion app may be down";
	}
	
	@HystrixCommand(fallbackMethod ="err_updatePerson")
	public String updatePerson(Person p)
	{
		Gateway.log.warn("--In Update Person service ");
		String res = temp.getForObject("http://Update-Service:8066/"
				+ "/update/"+p,String.class);
		System.out.println("Result:"+res);
		return res;
	}
	
	public String err_updatePerson(Person p) {
		return "Issue while updatation, Update App may be down";
	}
}