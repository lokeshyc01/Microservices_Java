package com.resilience.app.dto;

public class Order {
	private Long id;
	private String itemName;
	private String categoryName;
	private int price;
	
	public Order(Long id, String itemName, String categoryName, int price) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.categoryName = categoryName;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
