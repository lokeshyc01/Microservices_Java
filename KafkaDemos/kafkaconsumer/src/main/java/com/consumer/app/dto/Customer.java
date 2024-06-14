package com.consumer.app.dto;

public class Customer {
	
	private Long id;
	private Long age;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer(Long id, Long age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
}
