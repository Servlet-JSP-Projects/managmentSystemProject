package com.managementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.managementsystem.DBConnection.DBConnection;
import com.managementsystem.model.Employee;
import com.managementsystem.model.Login;

public class LoginDao {
	
	 static Employee employee=new Employee();

	public static boolean validate(Login login) {
		boolean isValidate = false;
		

		try {

			  Connection connection = DBConnection.getConnection();

			  PreparedStatement preparedStatement = connection
					  .prepareStatement("select * from employee where email = ? and password = ? ");
			  preparedStatement.setString(1, login.getEmail());
	          preparedStatement.setString(2, login.getPassword());

		      ResultSet result = preparedStatement.executeQuery();
		      if(result.next()){
		    	  isValidate = true;
	             
			      employee.setFirstName(result.getString("first_name"));
			      employee.setLastName(result.getString("last_name"));
			      employee.setPhonne(result.getInt("phone"));
			      employee.setaddres(result.getString("address"));
			      employee.setEmployeeID(result.getInt("employee_id"));
			      employee.setEmployeeRule(result.getString("employee_rule"));
			      employee.setEmail(result.getString("email"));
			      employee.setPassword(result.getString("password"));	  
		      }
		     

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return isValidate;
	}
	
	public static Employee getEmployee(){
		return employee;
	}
}
