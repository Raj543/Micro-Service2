package com.example.Cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mPojo.User;
import com.example.repo.mRepo;

@RestController
@RequestMapping("/ser-Update")
public class UpdateCont {
	
	@Autowired
	public mRepo repo;
	
	@RequestMapping("/update/{user}")
	public String update(@PathVariable("user") User u)
	{
		repo.save(u);
		return "Updated";
	}
}