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
import com.itvedant.services.BookServiceInterf;

@Controller
public class BookController {

	@Autowired
	BookServiceInterf service;
	
	/* Web Page mappings */
	
	@GetMapping({"/","/home"})
	public String homepage(Model model)
	{

		List<Book> books = service.getBooks();
		
		model.addAttribute("books",books);
		return "home.html";
	}
	
	@GetMapping("/registerbook")
	public String registerBook(Model model)
	{
		Book book = new Book();
		model.addAttribute("book",book);
		
		return "registerbook.html";
	}
	
	
	@GetMapping("/updatebook/{id}")
	public String updateBook(@PathVariable("id") int id,Model model)
	{
		
		Book book = service.getBookById(id);
		model.addAttribute("book",book);
		
		return "updatebook.html";
	}
	
	/* CRUD Mappings */
	
	@PostMapping("/addbook")
	public String addBook(@ModelAttribute Book newBook)
	{
		service.addBook(newBook);
		return "redirect:/adminhome";
	}
	
	@PutMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") int id,@ModelAttribute Book newBook)
	{
		Book book = service.getBookById(id);
		
		newBook.setAvailable(book.isAvailable());
		newBook.setCustomerEmail(book.getCustomerEmail());
		
		service.updateBook(newBook);
		return "redirect:/adminhome";
	}
	
	@DeleteMapping("/deletebook/{id}")
	public String delete(@PathVariable("id") int id)
	{
		service.deleteBook(id);

		return "redirect:/adminhome";
	}
	
	
	
	
	
}
