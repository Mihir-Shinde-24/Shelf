package com.itvedant.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.models.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Optional<Admin> findByEmail(String email);
}
