package com.example.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repo.mRepo;
import com.example.service.ServiceCom;

@RestController
@RequestMapping("/delService")
public class Cont {
	
	@Autowired
	public mRepo repo;
	
	@Autowired
	public ServiceCom com;
	
	@RequestMapping("/del/{id}")
	public String del(@PathVariable("id") int index) {
		repo.deleteById(index);
		return "Index "+index+" deleted";
		//return "Delete service ";
	}

}
