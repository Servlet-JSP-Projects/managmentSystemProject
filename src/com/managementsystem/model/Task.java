package com.managementsystem.model;

public class Task {
	
	private String name;
	private String description;
	private String status;
	private String createDate;
	private String finishDate;
	private int taskID;
	private int employeeID;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
	   this.name=name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
	   this.description=description;
	}

	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
	   this.status=status;
	}
	
	public String getCreateDate(){
		return createDate;
	}
	
	public void setCreateDate(String createDate){
	   this.createDate=createDate;
	}
	
	public String getFinishDate(){
		return finishDate;
	}
	
	public void setFinishDate(String finishDate){
	   this.finishDate=finishDate;
	}
	
	public int getTaskID(){
		return taskID;
	}
	
	public void setTaskID(int taskID){
	   this.taskID=taskID;
	}
	
	public int getEmployeeID(){
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID){
	   this.employeeID=employeeID;
	}
}

