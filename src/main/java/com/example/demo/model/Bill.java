package com.example.demo.model;

import java.util.List;

public class Bill {

	private String billNumber;
	private List<Item> items;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Double groceryItemsTotal() {
		return this.getItems().stream()
		.filter(item -> item.getItemCateogry() == Item.ItemCategory.GROCERIES)
		.mapToDouble(Item::getItemPrice)
		.sum();
	}
	public Double nonGroceryItemsTotal() {
		return this.getItems().stream()
		.filter(item -> item.getItemCateogry() != Item.ItemCategory.GROCERIES)
		.mapToDouble(Item::getItemPrice)
		.sum();
	}
	
}
