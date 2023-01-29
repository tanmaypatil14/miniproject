package com.myShopping.model;

public class Customer {
	private int customerId;
	private String userName;
	private String password;
	
	public Customer(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public Customer(int customerId, String userName, String password) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
