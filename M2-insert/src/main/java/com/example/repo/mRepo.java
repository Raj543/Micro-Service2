package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.pojo.Person;
import com.example.pojo.User;

public interface mRepo extends CrudRepository<Person,Integer>{

	//void save(Person p);
}
