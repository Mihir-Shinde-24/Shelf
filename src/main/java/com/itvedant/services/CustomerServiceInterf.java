package com.itvedant.services;

import java.util.List;

import com.itvedant.models.Customer;

public interface CustomerServiceInterf {

	// 1. Add
	public void addCustomer(Customer newCustomer);
	
	// 2. Get Customers
	public List<Customer> getCustomers();
	
	// 3. Update Customer
	public void updateCustomer(Customer newCustomer);
	
	// 4. Delete Customer
	public void deleteCustomer(int id);
	
	// 5. Get by id
	public Customer getCustomerById(int id);
	
}
