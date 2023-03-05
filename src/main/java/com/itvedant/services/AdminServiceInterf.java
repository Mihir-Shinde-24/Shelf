package com.itvedant.services;

import java.util.List;

import com.itvedant.models.Admin;

public interface AdminServiceInterf {

	// 1. Add Admin
	public String addAdmin(Admin newAdmin);

	// 2. Get Admins
	public List<Admin> getAdmins();

	// 3. Get Admin By Id
	public Admin getAdminById(int id);

	// 4. Update Admin
	public String updateAdmin(Admin newAdmin);

	// 5. Del by Id
	public void deleteById(int id);
}
