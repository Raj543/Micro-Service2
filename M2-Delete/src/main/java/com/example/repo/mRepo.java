package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.Pojo.Person;
import com.example.Pojo.User;

@Component
public interface mRepo extends CrudRepository<Person,Integer>{}
