package com.kafka.app.dto;

public class Customer {
	
	private Long id;
	private Long age;
	private String name;
	private String ipAddress;
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Customer() {};

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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", age=" + age + ", name=" + name + ", ipAddress=" + ipAddress + "]";
	}
	
}
