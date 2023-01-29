package com.myShopping.serviceimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.myShopping.model.Customer;
import com.myShopping.model.Product;
import com.myShopping.service.MyShoppingService;

public class MyShoppingServiceImpl implements MyShoppingService {

	static Connection connection = null;
	static Statement statement = null;
	static PreparedStatement preparedStatement = null;
	static Scanner input = new Scanner(System.in);

	@Override
	public int addProduct() {
		int row = 0;
		try {

			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			preparedStatement = connection.prepareStatement("insert into product1 values(?,?,?,?)");
			System.out.println("Enter Product Details");
			System.out.println("Enter Product_Id");
			int pId = input.nextInt();
			System.out.println("Enter Product Name");
			String pName = input.next();
			System.out.println("Enter Product Price");
			int pPrice = input.nextInt();
//			float pPrice = input.nextFloat();
			System.out.println("Enter Product Type");
			String pType = input.next();

			preparedStatement.setInt(1, pId);
			preparedStatement.setString(2, pName);
			preparedStatement.setInt(3, pPrice);
			preparedStatement.setString(4, pType);

			row = preparedStatement.executeUpdate();
			System.out.println(row + "rows affected");
			System.out.println("Product details added Successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;

	}

	@Override
	public int updateProduct() {
		int row = 0;
		try {

			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			preparedStatement = connection.prepareStatement(
					"update product1 set productName = ?, productPrice = ?, productType = ? where productId = ?");
			System.out.println("Enter Product Details");
			System.out.println("Enter Product_Id");
			int pId = input.nextInt();
			System.out.println("Enter Product Name");
			String pName = input.next();
			System.out.println("Enter Product Price");
			int pPrice = input.nextInt();
			System.out.println("Enter Product Type");
			String pType = input.next();

			preparedStatement.setInt(4, pId);
			preparedStatement.setString(1, pName);
			preparedStatement.setInt(2, pPrice);
			preparedStatement.setString(3, pType);

			row = preparedStatement.executeUpdate();
			System.out.println(row + "rows affected");
			System.out.println("Product detail updated successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteProduct() {
		int row = 0;
		try {

			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			preparedStatement = connection.prepareStatement("delete from product1 where productId = ?");
			System.out.println("Enter Product Details");
			System.out.println("Enter Product_Id");
			int pId = input.nextInt();

			preparedStatement.setInt(1, pId);

			row = preparedStatement.executeUpdate();
			System.out.println(row + "rows affected");
			System.out.println("Product removed Successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public void getProductById() {
		try {

			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			preparedStatement = connection.prepareStatement("select * from product1 where productId = ?");
			System.out.println("Enter Product Details");
			System.out.println("Enter Product_Id");
			int pId = input.nextInt();

			preparedStatement.setInt(1, pId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " "
						+ resultSet.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> listProduct = new ArrayList<Product>();

		try {
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from product1");
			while (resultSet.next()) {
				Product prod = new Product();
				prod.setProductId(resultSet.getInt(1));
				prod.setProductName(resultSet.getString(2));
				prod.setProductPrice(resultSet.getInt(3));
				prod.setProductType(resultSet.getString(4));
				listProduct.add(prod);
			}

			for (Product product : listProduct) {
				System.out.println(product.getProductId() + "--" + product.getProductName() + "--"
						+ product.getProductPrice() + "--" + product.getProductType());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	@Override
	public int addCustomer() {
		int row = 0;
		try {

			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			preparedStatement = connection.prepareStatement("insert into customer values(?,?,?)");
			System.out.println("Enter Customer Details");
			System.out.println("Enter Customer Id");
			int cId = input.nextInt();
			System.out.println("Enter Customer User Name");
			String cUserName = input.next();
			System.out.println("Enter Customer Password");
			String cPassword = input.next();

			preparedStatement.setInt(1, cId);
			preparedStatement.setString(2, cUserName);
			preparedStatement.setString(3, cPassword);

			row = preparedStatement.executeUpdate();
			System.out.println(row + "rows affected");
			System.out.println("customer details added Successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int updateCustomerPassword() {
		int row = 0;
		try {

			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			preparedStatement = connection
					.prepareStatement("update customer set customer_password = ? where customer_username = ?");
			System.out.println("Enter Customer Details");

			System.out.println("Enter Customer User Name");
			String cUserName = input.next();
			System.out.println("Enter Customer Password");
			String cPassword = input.next();

			preparedStatement.setString(2, cUserName);
			preparedStatement.setString(1, cPassword);

			row = preparedStatement.executeUpdate();
			System.out.println(row + "rows affected");
			System.out.println("customer detail updated Successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteCustomer() {
		int row = 0;
		try {

			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			preparedStatement = connection.prepareStatement("delete from customer where customer_username = ?");
			System.out.println("Enter Customer Details");

			System.out.println("Enter Customer User Name");
			String cUserName = input.next();

			preparedStatement.setString(1, cUserName);

			row = preparedStatement.executeUpdate();
			System.out.println(row + "rows affected");
			System.out.println("Customer detail removed Successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public void getCustomerById() {
		try {

			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");

			preparedStatement = connection.prepareStatement("select * from customer where customer_id =?");
			System.out.println("Enter Customer Details");

			System.out.println("Enter Customer Id");
			int cId = input.nextInt();

			preparedStatement.setInt(1, cId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Customer UserName = " + resultSet.getString(2) + " & Customer Password = "
						+ resultSet.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> listCustomer = new ArrayList<Customer>();

		try {
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://IMC5BCP84-MSL2\\SQLEXPRESS2019;databaseName=shopping;user=sa;password=password_123");
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from customer");
			while (resultSet.next()) {
				Customer cust = new Customer();
				cust.setCustomerId(resultSet.getInt(1));
				cust.setUserName(resultSet.getString(2));
				cust.setPassword(resultSet.getString(3));
				listCustomer.add(cust);
			}

			for (Customer customer : listCustomer) {
				System.out.println(
						customer.getCustomerId() + "--" + customer.getUserName() + "--" + customer.getPassword());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCustomer;
	}

}
