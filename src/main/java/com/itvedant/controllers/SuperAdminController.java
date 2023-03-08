package com.itvedant.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.itvedant.models.Admin;
import com.itvedant.models.Book;
import com.itvedant.models.Customer;
import com.itvedant.services.AdminServiceInterf;
import com.itvedant.services.BookServiceInterf;
import com.itvedant.services.CustomerServiceInterf;

@Controller
public class SuperAdminController {

	@Autowired
	AdminServiceInterf service;
	
	@Autowired
	BookServiceInterf bookService;
	
	@Autowired
	CustomerServiceInterf customerService;
	
	@Autowired
	PasswordEncoder encoder;

	/* Web Page Mapping */

	@GetMapping("/registeradmin")
	public String registerAdmin(Model model)
	{
		Admin admin = new Admin();
		model.addAttribute("admin", admin);

		return "registeradmin.html";
	}

	@GetMapping("/superhome")
	public String superHome(Model model)
	{
		List<Admin> admins = service.getAdmins();
		model.addAttribute("admins", admins);
		
		List<Customer> customers = customerService.getCustomers();
		List<Book> books = bookService.getBooks();
		
		model.addAttribute("customers",customers);
		model.addAttribute("books",books);
		
		return "superhome.html";
	}

	@GetMapping("/updateadmin/{id}")
	public String updateAdmin(@PathVariable("id") int id, Model model)
	{
		Admin admin = service.getAdminById(id);
		model.addAttribute("admin", admin);
		return "updateadmin.html";
	}

	/* CRUD Mapping */
	@PostMapping("/addadmin")
	public String addAdmin(@ModelAttribute("admin") @Valid Admin newAdmin,BindingResult result )
	{
		if(result.hasErrors())
		{
			return "registeradmin.html";
		}
		
		newAdmin.setPasscode(encoder.encode(newAdmin.getPasscode()));
		newAdmin.setRole("ROLE_ADMIN");
		service.addAdmin(newAdmin);

		return "redirect:/superhome";
	}
	
	@PutMapping("/update/{id}")
	public String update(@ModelAttribute("admin") @Valid Admin newAdmin)
	{
		newAdmin.setPasscode(encoder.encode(newAdmin.getPasscode()));
		newAdmin.setRole("ROLE_ADMIN");
		service.updateAdmin(newAdmin);

		return "redirect:/superhome";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		service.deleteById(id);

		return "redirect:/superhome";
	}
	
	
	
	
	/* Role Based Redirection for Home Page */
	
	@GetMapping("/default")
	public String successPage(HttpServletRequest request)	
	{
		if(request.isUserInRole("SUPER"))
		{
			return "redirect:/superhome";
		}
		else if(request.isUserInRole("ADMIN"))
		{
			return "redirect:/adminhome";
		}
		else {
			return "redirect:/";
		}
	}
	
	

}
