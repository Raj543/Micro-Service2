package com.example.pojo;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;


@Entity
public class Person {
	@Id
	private Integer id;
	private String name;
	@Value("email")
	private String email;
	@Value("pwd")
	private String pwd;
	
	public Person() {
		super();
	}
	
	public Person(Integer id, String name, String email, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String address) {
		this.email = address;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String company) {
		this.pwd = company;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + email + ", password=" + pwd + "]";
	}
}
