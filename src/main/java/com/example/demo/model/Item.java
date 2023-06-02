package com.example.demo.model;

public class Item {

	public static enum ItemCategory {
		GROCERIES, STATIONARY, APPAREL;
	}
	
	private String itemName;
	private Float itemPrice;
	private ItemCategory itemCateogry;
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public ItemCategory getItemCateogry() {
		return itemCateogry;
	}
	public void setItemCateogry(ItemCategory itemCateogry) {
		this.itemCateogry = itemCateogry;
	}
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemCateogry=" + itemCateogry + "]";
	}
	
}
