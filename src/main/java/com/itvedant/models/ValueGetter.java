package com.itvedant.models;

public class ValueGetter {

	String text;
	boolean check;
	public ValueGetter(String text, boolean check)
	{
		super();
		this.text = text;
		this.check = check;
	}
	public ValueGetter()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public boolean isCheck()
	{
		return check;
	}
	public void setCheck(boolean check)
	{
		this.check = check;
	}
	

	
}
