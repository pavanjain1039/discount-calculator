package com.example.demo.model;

import java.util.Date;

public class User {

	public static enum UserType{
		STORE_EMPLOYEE, STORE_AFFILIATE,GENERAL;
	}
	
	private String userName;
	private Date userSince;
	private UserType userType;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getUserSince() {
		return userSince;
	}
	public void setUserSince(Date userSince) {
		this.userSince = userSince;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userSince=" + userSince + ", userType=" + userType + "]";
	}
	
}
