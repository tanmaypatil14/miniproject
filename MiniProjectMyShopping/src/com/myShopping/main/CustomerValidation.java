package com.myShopping.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.myShopping.model.Product;

public class CustomerValidation {

	static Scanner scanner = new Scanner(System.in);

	public void getCustomerCredentials() throws ClassNotFoundException {

		
		System.out.println("Enter User Name :");
		String uName = scanner.nextLine();
		System.out.println("Enter Password : ");
		String pwd = scanner.nextLine();

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from customer where customer_username = ? and customer_password = ?");
			preparedStatement.setString(1, uName);
			preparedStatement.setString(2, pwd);
			ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {

				System.out.println("\n------Select Category---------\r\n" + "1. Laptop\r\n" + "2. Phones\r\n"
						+ "3. Furniture\r\n" + "4. Fashion\r\n" + "5. Home Appliances\r\n" + "0. Exit\r\n"
						+ "-----------------------------");
				System.out.println("Enter category");
				int choice = scanner.nextInt();
				getProducts(choice);

			} else {
				System.out.println("Invalid Credentials,Please try again");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getProducts(int pChoice) throws ClassNotFoundException, SQLException {
		List<Product> listproducts = new ArrayList<Product>();

		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");
			PreparedStatement pstmt = connection.prepareStatement("select * from product1 where productType = ?");
			if (pChoice == 1)
				pstmt.setString(1, "Laptop");
			else if (pChoice == 2)
				pstmt.setString(1, "Phones");
			else if (pChoice == 3)
				pstmt.setString(1, "Furniture");
			else if (pChoice == 4)
				pstmt.setString(1, "Fashion");
			else if (pChoice == 5)
				pstmt.setString(1, "HomeAppliances");
			else {
				System.out.println("invalid");
			}

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				Product p = new Product();
				p.setProductId(resultSet.getInt("productId"));
				p.setProductName(resultSet.getString("productName"));
				p.setProductPrice(resultSet.getInt("productPrice"));
//				p.setProductType(resultSet.getString("productType"));
				listproducts.add(p);
			}
			for (Product product : listproducts) {
//				System.out.println(product.getProductId() + "--" + product.getProductName() + "--" + product.getProductPrice() + "--" + product.getProductType());
				System.out.println(
						product.getProductId() + "--" + product.getProductName() + "--" + product.getProductPrice());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listproducts;
	}
}
