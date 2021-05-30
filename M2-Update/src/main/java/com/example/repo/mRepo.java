package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.mPojo.User;

@Repository(value="mRepo")
public interface mRepo extends CrudRepository<User,Integer>{}
