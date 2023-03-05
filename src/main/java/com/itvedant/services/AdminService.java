package com.itvedant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.exceptions.AdminDBException;
import com.itvedant.models.Admin;
import com.itvedant.repositories.AdminRepo;

@Service
public class AdminService implements AdminServiceInterf{

	@Autowired
	AdminRepo repo;
	
	@Override
	public String addAdmin(Admin newAdmin)
	{
		Optional<Admin> admin = repo.findByEmail(newAdmin.getEmail());
		if(admin.isEmpty())
		{
			repo.save(newAdmin);
			return "Admin Added!";
		}
		throw new AdminDBException("Admin already Exists");
		
		
	}

	@Override
	public List<Admin> getAdmins()
	{
		return repo.findAll();
	}

	@Override
	public Admin getAdminById(int id)
	{
		return repo.findById(id).get();
	}

	@Override
	public String updateAdmin(Admin newAdmin)
	{
		repo.save(newAdmin);
		return "Admin Updated!";
		
	}

	@Override
	public void deleteById(int id)
	{
		repo.deleteById(id);
	}

}
