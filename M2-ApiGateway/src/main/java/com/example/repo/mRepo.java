package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.Person;

@Repository(value="mRepo")
public interface mRepo extends CrudRepository<Person,Integer> {}
