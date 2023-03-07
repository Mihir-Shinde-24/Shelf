package com.itvedant.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.models.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

	public Optional<Book> findByTitle(String title);
}
