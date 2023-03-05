package com.itvedant.services;

import java.util.List;

import com.itvedant.models.Book;

public interface BookServiceInterf {

	// 1. Get Book
	public List<Book> getBooks();
	
	// 2. Add Book
	public void addBook(Book newBook);
	
	// 3. Update Book
	public void updateBook(Book newBook);
	
	// 4. Delete Book
	public void deleteBook(int id);

	// 5. Get by id
	public Book getBookById(int id);

}
