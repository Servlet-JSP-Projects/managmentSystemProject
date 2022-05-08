package com.managementsystem.model;

public class Employee {
	
	private String firstName;
	private String lastName;
	private int phone;
	private String addres;
	private int employeeID;
	private String employeeRule;
	private String email;
	private String password;
	
	public Employee(String firstName,String lastName,int phone,String addres,int employeeID,String employeeRule,String email,String password){
		this.firstName=firstName;
		this.lastName=lastName;
		this.phone=phone;
		this.addres=addres;
		this.employeeID=employeeID;
		this.employeeRule=employeeRule;
		this.email=email;
		this.password=password;	
	}
	public Employee(){
		
	}
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
	   this.firstName=firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
	   this.lastName=lastName;
	}
	
	public int getPhone(){
		return phone;
	}
	
	public void setPhonne(int phone){
	   this.phone=phone;
	}
	
	public String getaddres(){
		return addres;
	}
	
	public void setaddres(String addres){
	   this.addres=addres;
	}
	
	public int getEmployeeID(){
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID){
	   this.employeeID=employeeID;
	}
	
	public String getEmployeeRule(){
		return employeeRule;
	}
	
	public void setEmployeeRule(String employeeRule){
	   this.employeeRule=employeeRule;
	}
	
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
	   this.email=email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
	   this.password=password;
	}
	
}
