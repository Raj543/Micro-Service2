package com.example.mPojo;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	private Integer id;
	private String name,address,company;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", company=" + company + "]";
	}
}
