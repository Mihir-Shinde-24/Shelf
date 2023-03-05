package com.itvedant.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	public Optional<Customer> findByEmail(String email);
}
