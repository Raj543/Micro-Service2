package com.example.mService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mPojo.User;
import com.example.repo.mRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AppService {
	
	@Autowired
	public mRepo repo;
	
	@Autowired
	public  RestTemplate temp;
	 
	
	public AppService() {
		super();
	}


	@HystrixCommand(fallbackMethod = "errorUpdate")
	public String update(User u) {
		User u1;
		Optional<User> user = repo.findById(u.getId());
		if (user.isPresent()){
			System.out.println("User found, Going to update it");
			u1 = user.get();
			u1.setName(u1.getName());
			u1.setEmail(u1.getEmail());
			u1.setPwd(u1.getPwd());	
		}else {
			System.out.println("User for this id is not found");
			return null;
		}
		System.out.println("User is going to save");
		repo.save(u1);
		System.out.println("User is saved");
		//Person upPer = temp.getForObject("http://list-service:8060/show/getById/"+id,Person.class);
		Optional<User> upPer = repo.findById(u1.getId());
		if(upPer.isPresent()) {
			System.out.println("Update Person :"+upPer);
		}
		return "Updated";
	}
}