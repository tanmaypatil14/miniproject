package com.myShopping.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminValidation {
	static Scanner scanner = new Scanner(System.in);
	public void getAdminCredentials() throws ClassNotFoundException {
		
		System.out.println("----------------- Welcome To MyShopping Application -----------------");
		System.out.println("Enter User Name :");
		String uName = scanner.nextLine();
		System.out.println("Enter Password : ");
		String pwd = scanner.nextLine();
		
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where ausername=? and apassword=?");
			preparedStatement.setString(1, uName);
			preparedStatement.setString(2, pwd);
			ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				System.out.println(" ");
				System.out.println(uName + " " + uName);
				System.out.println("Log-in Successful..........");
				System.out.println(" ");
				
				AdminAuthorizationList adminAuthorizationList = new AdminAuthorizationList();
				adminAuthorizationList.getAdminAuthorizationList();
			} else {
				System.out.println("Invalid Credentials, Please try again");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		scanner.close();
	}
	
}
