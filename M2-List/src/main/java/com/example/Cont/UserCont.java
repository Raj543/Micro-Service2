package com.example.Cont;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Person;
import com.example.pojo.User;
import com.example.repo.mRepo;

@RestController
@RequestMapping("/show")
@DependsOn("mRepo")
public class UserCont {
	
	@Autowired
	public mRepo repo;
	
	@RequestMapping("/getById/{id}")
	public Optional<Person> listById(@PathVariable("id") int id) {
		System.out.println("List user called");
		Optional<Person> us = repo.findById(id);
		System.out.println("User:"+us);
		if (us.isPresent()) {
			System.out.println("User :"+us);
			return us;
		}else
			return null;
	}
	
	@RequestMapping("/getAll")
	public Iterable<Person> listAll(){
		Iterable<Person> user = repo.findAll();
		System.out.println("List of all person");
		for(Person u : user) {
			System.out.println(u);
		}
		return user;
	}
}
