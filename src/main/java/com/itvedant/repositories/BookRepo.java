package com.itvedant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.models.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
