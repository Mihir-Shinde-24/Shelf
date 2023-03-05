package com.itvedant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.itvedant.models.Book;
import com.itvedant.models.Customer;
import com.itvedant.models.ValueGetter;
import com.itvedant.services.BookServiceInterf;
import com.itvedant.services.CustomerServiceInterf;

@Controller
public class AdminController {

	@Autowired
	BookServiceInterf bookService;
	
	@Autowired
	CustomerServiceInterf customerService;

	/* Web Page Mapping */
	@GetMapping("/adminhome")
	public String adminhome(Model model)
	{

		List<Customer> customers = customerService.getCustomers();
		List<Book> books = bookService.getBooks();
		
		model.addAttribute("customers",customers);
		model.addAttribute("books",books);
		
		
		return "adminhome.html";
	}

	@GetMapping("/registercustomer")
	public String registerCustomer(Model model)
	{
		Customer customer = new Customer();
		List<Book> books = bookService.getBooks();
		
		model.addAttribute("customer",customer);
		model.addAttribute("books",books);
		
		return "registercustomer.html";
	}
	
	@GetMapping("/updatecustomer/{id}")
	public String updateCustomer(@PathVariable("id") int id, Model model)
	{
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer",customer);		
		
		List<Book> books = bookService.getBooks();
		model.addAttribute("books",books);
		return "updatecustomer.html";
		
	}

	/* CRUD Mapping */
	
	@PostMapping("/addcustomer")
	public String addCustomer(@ModelAttribute Customer newCustomer)
	{
		customerService.addCustomer(newCustomer);		
		return "redirect:/adminhome";
	}
	
	@PutMapping("/editcustomer/{id}")
	public String editCustomer(@ModelAttribute Customer newCustomer)
	{
		customerService.updateCustomer(newCustomer);		
		return "redirect:/adminhome";
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		customerService.deleteCustomer(id);
		return "redirect:/adminhome";
	}

}
