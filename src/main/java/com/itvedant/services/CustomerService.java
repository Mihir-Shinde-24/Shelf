package com.itvedant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.exceptions.CustomerDBException;
import com.itvedant.models.Customer;
import com.itvedant.repositories.CustomerRepo;

@Service
public class CustomerService implements CustomerServiceInterf {

	@Autowired
	CustomerRepo repo;

	@Override
	public void addCustomer(Customer newCustomer)
	{
		Optional<Customer> customer = repo.findByEmail(newCustomer.getEmail());

		System.out.println(newCustomer.getBookName().isBlank());

		
		if(customer.isEmpty())
		{
			if (newCustomer.getBookName().isBlank())
			{
				newCustomer.setHasTakenBook(false);
			}
			else
			{
				newCustomer.setHasTakenBook(true);

			}
			
			repo.save(newCustomer);			
		}
		else {			
			throw new CustomerDBException("Customer Already Exists!");
		}
		
		
	}

	@Override
	public List<Customer> getCustomers()
	{
		return repo.findAll();
	}

	@Override
	public void updateCustomer(Customer newCustomer)
	{
		Optional<Customer> customer = repo.findByEmail(newCustomer.getEmail());
		
		if(customer.isPresent())
		{
			if (newCustomer.getBookName().isBlank())
			{
				newCustomer.setHasTakenBook(false);
			}
			else
			{
				newCustomer.setHasTakenBook(true);

			}
			
			repo.save(newCustomer);			
		}
		else {			
			throw new CustomerDBException("Customer Doesn't Exist!");
		}
	}

	@Override
	public void deleteCustomer(int id)
	{
		repo.deleteById(id);
	}

	@Override
	public Customer getCustomerById(int id)
	{
		return repo.findById(id).get();
	}

}
