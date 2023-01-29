package com.myShopping.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.myShopping.service.MyShoppingService;
import com.myShopping.serviceimpl.MyShoppingServiceImpl;

public class AdminAuthorizationList {
	static Scanner scanner = new Scanner(System.in);

	public void getAdminAuthorizationList() throws ClassNotFoundException, SQLException {

		System.out.println("--------- Admin Menu ---------");
		System.out.println(
				"1. Add Product \n2. Update Product \n3. Delete Product \n4. Get Product by ID \n5. Get All Products \n6. Add customer \n7. Update Customer Information \n8. Delete Customer \n9. Get Customer by ID \n10. Get All Customer \n0. Exit");
		int choice = scanner.nextInt();
		MyShoppingService myShoppingService = new MyShoppingServiceImpl();
		switch (choice) {
		case 1:
			System.out.println("1. Add Product");

			myShoppingService.addProduct();
			break;
		case 2:
			System.out.println("2. Update Product");

			myShoppingService.updateProduct();
			break;
		case 3:
			System.out.println("3. Delete Product");
			myShoppingService.deleteProduct();
			break;
		case 4:
			System.out.println("4. Get Product by ID");
			myShoppingService.getProductById();
			break;
		case 5:
			System.out.println("5. Get All Products");
			myShoppingService.getAllProduct();
			break;
		case 6:
			System.out.println("6. Add customer");
			myShoppingService.addCustomer();
			break;
		case 7:
			System.out.println("7. Update Customer Information");
			myShoppingService.updateCustomerPassword();
			break;
		case 8:
			System.out.println("8. Delete Customer");
			myShoppingService.deleteCustomer();
			break;
		case 9:
			System.out.println("9. Get Customer by ID");
			myShoppingService.getCustomerById();
			break;
		case 10:
			System.out.println("10. Get All Customer");
			myShoppingService.getAllCustomer();
			break;
		case 0:
			System.out.println("0. Exit");
			MyShoppingMain myShoppingMain = new MyShoppingMain();
			myShoppingMain.getMyShoppingMain();
			break;
		}

		int returnToMenu = scanner.nextInt();

		if (returnToMenu == 0) {
		}

	}
}
