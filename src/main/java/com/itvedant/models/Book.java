package com.itvedant.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String title;
	
	@Column
	String description;
	
	@Column
	double price;
	
	@Column
	boolean isAvailable;
	
	@Column
	String customerEmail;

	/* Constructor */
	
	public Book(int id, String title, String description, double price, boolean isAvailable, String customerEmail)
	{
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.customerEmail = customerEmail;
	}

	public Book()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/* Getter Setter */
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public boolean isAvailable()
	{
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}

	public String getCustomerEmail()
	{
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail)
	{
		this.customerEmail = customerEmail;
	}
	
	
	
	
}
