package com.myShopping.model;

public class Admin {

	private String adminUserName;
	private String adminPassword;

	public Admin(String adminUserName, String adminPassword) {
		super();
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
