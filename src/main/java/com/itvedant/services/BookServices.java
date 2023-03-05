package com.itvedant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.models.Book;
import com.itvedant.repositories.BookRepo;

@Service
public class BookServices implements BookServiceInterf{

	@Autowired
	BookRepo repo;
	
	@Override
	public List<Book> getBooks()
	{
		return repo.findAll();
	}

	@Override
	public void addBook(Book newBook)
	{
		newBook.setAvailable(true);
		newBook.setCustomerEmail(null);
		repo.save(newBook);
		
	}

	@Override
	public void updateBook(Book newBook)
	{
		repo.save(newBook);
	}

	@Override
	public void deleteBook(int id)
	{
		repo.deleteById(id);		
	}

	@Override
	public Book getBookById(int id)
	{
		return repo.findById(id).get();
	}

}
