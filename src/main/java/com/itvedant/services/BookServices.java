package com.itvedant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.exceptions.BookDBException;
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
		Optional<Book> book = repo.findById(id);
		if(book.get().isAvailable())
		{
			repo.deleteById(id);					
		}
		else {			
			throw new BookDBException("Book Can Not to deleted! Customer Owns it.");
		}
		
	}

	@Override
	public Book getBookById(int id)
	{
		return repo.findById(id).get();
	}

}
