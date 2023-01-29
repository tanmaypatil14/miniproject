package com.myShopping.service;

import java.util.List;

import com.myShopping.model.*;

public interface MyShoppingService {

//	Below CRUD operation for Product
	public int addProduct();

	public int updateProduct();

	public int deleteProduct();

	public void getProductById();

	public List<Product> getAllProduct();

//	Below CRUD operation for Customer
	public int addCustomer();

	public int updateCustomerPassword();

	public int deleteCustomer();

	public void getCustomerById();

	public List<Customer> getAllCustomer();

}
