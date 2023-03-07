package com.itvedant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.exceptions.CustomerDBException;
import com.itvedant.models.Book;
import com.itvedant.models.Customer;
import com.itvedant.repositories.BookRepo;
import com.itvedant.repositories.CustomerRepo;

@Service
public class CustomerService implements CustomerServiceInterf {

	@Autowired
	CustomerRepo repo;
	
	@Autowired
	BookRepo bookRepo;

	@Override
	public void addCustomer(Customer newCustomer)
	{
		Optional<Customer> customer = repo.findByEmail(newCustomer.getEmail());

		if(customer.isEmpty())
		{
			if (newCustomer.getBookName().isBlank())
			{
				newCustomer.setHasTakenBook(false);
				
//				Optional<Book> book = bookRepo.findByTitle(newCustomer.getBookName());
//				
//				book.get().setAvailable(true);
//				book.get().setCustomerEmail(null);
			}
			else
			{
				newCustomer.setHasTakenBook(true);				
				Optional<Book> book = bookRepo.findByTitle(newCustomer.getBookName());
				
				book.get().setAvailable(false);
				book.get().setCustomerEmail(newCustomer.getEmail());
				
				bookRepo.save(book.get());
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
				
				if(customer.get().isHasTakenBook())
				{
					Optional<Book> book = bookRepo.findByTitle(customer.get().getBookName());
					book.get().setAvailable(true);
					book.get().setCustomerEmail(null);
				}
				
			}
			else
			{
				newCustomer.setHasTakenBook(true);
				
				Optional<Book> book = bookRepo.findByTitle(newCustomer.getBookName());
				
				book.get().setAvailable(false);
				book.get().setCustomerEmail(newCustomer.getEmail());
				bookRepo.save(book.get());
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
