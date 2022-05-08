package com.managementsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;

import com.managementsystem.DBConnection.DBConnection;
import com.managementsystem.model.Task;
public class TaskDao {

	public static List<Task> MyTask(int employeeID) {


		List<Task> tasks = new ArrayList<>();

		try 
		{ 
			 Connection connection = DBConnection.getConnection();

			 PreparedStatement preparedStatement = connection
					  .prepareStatement("select * from task where employee_id=?");
			preparedStatement.setInt(1, employeeID);
			
			ResultSet result = preparedStatement.executeQuery();

		    
			while (result.next()) {
				Task task=setTask(result);
				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return tasks;
	}

	public static void insertTask(int employeeID,String name,String description) {

		LocalDate date= LocalDate.now();
		Random random = new Random();
		int randomNum =  random.nextInt(50000000);
		System.out.println("System.out.println(randomNum);");
		System.out.println(employeeID);

		try 
		{ 
			 Connection connection = DBConnection.getConnection();

//			 PreparedStatement preparedStatement = connection
//					  .prepareStatement("insert into task (task_id,name,description,status,create_date,finish_date,employee_id) valuse"
//					  	   	+ "('"+randomNum+"','"+name+"','"+description+"','In Progress','"+date.toString()+"','-','"+employeeID+"')");
//			
			 PreparedStatement preparedStatement = connection
					  .prepareStatement("INSERT INTO task (task_id,name,description,status,create_date,finish_date,employee_id) VALUES (?,?,?,?,?,?,?)");
			 preparedStatement.setInt(1, randomNum);
			 preparedStatement.setString(2, name);
			 preparedStatement.setString(3, description);
			 preparedStatement.setString(4, "In Progress");
			 preparedStatement.setString(5, date.toString());
			 preparedStatement.setString(6, "-");
			 preparedStatement.setInt(7, employeeID);
			 
			 preparedStatement.executeUpdate();

		   
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

	
	public static List<Task> editTask(int id,int emplyeeID,String text) {

		List<Task> tasks = new ArrayList<>();
		String date="";
		if(text.equals("Completed")) date=LocalDate.now().toString();
		else date= "-";
		
		try 
		{ 
			 Connection connection = DBConnection.getConnection();

			  PreparedStatement preparedStatement = connection
					  .prepareStatement("update task set status=?,finish_date=? where task_id=?");
			  preparedStatement.setString(1, text);
			  preparedStatement.setString(2, date.toString());
			  preparedStatement.setInt(3, id);
			 // Step 3: Execute the query or update query
			 preparedStatement.executeUpdate();
			 
             tasks=MyTask(emplyeeID);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return tasks;
	}

	public static void deleteTask(int id) {

		try 
		{ 
			 Connection connection = DBConnection.getConnection();

			 PreparedStatement preparedStatement = connection.prepareStatement("delete from task where task_id=?");
			 preparedStatement.setInt(1, id);
		
			 preparedStatement.executeUpdate();
			 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void deleteCompTask() {

		try 
		{ 
			 Connection connection = DBConnection.getConnection();

			 PreparedStatement preparedStatement = connection.prepareStatement("delete from task where status=?");
			 preparedStatement.setString(1, "Completed");
		
			 preparedStatement.executeUpdate();
			 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static Task setTask(ResultSet result ) throws SQLException{
		Task task=new Task();
		task.setName(result.getString("name"));
		task.setDescription(result.getString("description"));
		task.setStatus(result.getString("status"));
		task.setCreateDate(result.getString("create_date"));
		task.setFinishDate(result.getString("finish_date"));
		task.setTaskID(result.getInt("task_id"));
		task.setEmployeeID(result.getInt("employee_id"));
		return task;
	}
}
