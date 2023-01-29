package com.myShopping.main;

import java.sql.SQLException;
import java.util.Scanner;

public class MyShoppingMain {
	static Scanner scanner = new Scanner(System.in);

	public void getMyShoppingMain() throws ClassNotFoundException, SQLException {
		System.out.println("----------------- Welcome To MyShopping Application -----------------");
		System.out.println("---------MENU---------");
		System.out.println("1. Admin \n2. Customer \n0. Exit");
		System.out.println("----------------------");
		System.out.println("Enter Menu Number : ");
		int menuId = scanner.nextInt();

		switch (menuId) {
		case 1:
//			Below object is related to admin
			AdminValidation adminValidation = new AdminValidation();
			adminValidation.getAdminCredentials();
			break;
		case 2:
//			Below object is related to customer
			CustomerValidation customerValidation = new CustomerValidation();
			customerValidation.getCustomerCredentials();

		case 0:
			System.exit(0);
		}

		scanner.close();

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MyShoppingMain myShoppingMain = new MyShoppingMain();
		myShoppingMain.getMyShoppingMain();
	}
}
