package com.managementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.managementsystem.DBConnection.DBConnection;
import com.managementsystem.model.Employee;
import com.managementsystem.model.Team;

public class EmployeeDao {
	
	public static List<Employee> AllDevloper() {
		List<Employee> employees = new ArrayList<>();
		try 
		{ 
			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedStatement = connection
					  .prepareStatement("select * from employee where employee_rule=?");
			preparedStatement.setString(1, "Developer");
			
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Employee employee=setEmployee(result);
				employees.add(employee);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return employees;
	}
	
	public static List<Employee> TeamDevloper(int id) {
		List<Employee> employees = new ArrayList<>();
		try 
		{ 
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement1 = connection.prepareStatement("select team_id from team where team_leader_id=? ");
			preparedStatement1.setInt(1, id);
			ResultSet result1 = preparedStatement1.executeQuery();
			result1.next();
			
			PreparedStatement preparedStatement = connection
					  .prepareStatement("select * from employee join employee_team on employee.employee_id=employee_team.employee_id where team_id=?");
			preparedStatement.setInt(1, result1.getInt("team_id"));
			
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Employee employee=setEmployee(result);
				employees.add(employee);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return employees;
	}
	
	public static String employeeName(int employeeID) {
		String name="";
		try 
		{ 
			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedStatement = connection
					  .prepareStatement("select first_name,last_name from employee where employee_id =?");
			preparedStatement.setInt(1, employeeID);
			
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				name=result.getString("first_name")+" "+result.getString("last_name");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return name;
	}
	
	public static List<Team> Team() {
		List<Team> teams = new ArrayList<>();
		try
		{ 
			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedStatement1 = connection
					  .prepareStatement("select * from employee inner join team on employee.employee_id=team.team_leader_id "
					  + "where employee_rule=?");
			preparedStatement1.setString(1, "TeamLeader");
				
			ResultSet result1 = preparedStatement1.executeQuery();
//			
			while (result1.next()) {
				PreparedStatement preparedStatement2 = connection
						  .prepareStatement("select count(employee_id) as count from employee_team where team_id=?");
				preparedStatement2.setInt(1,Integer.valueOf(result1.getString("team_id")));
					
				ResultSet result2 = preparedStatement2.executeQuery();
				result2.next();
				Team team=new Team();
				team.setTeamLeaderID(result1.getInt("team_leader_id"));
				team.setTeamID(result1.getInt("team_id"));
				team.setTeamName(result1.getString("team_name"));
				team.setTeamLeader(result1.getString("first_name")+" "+result1.getString("last_name"));
				team.setNumberDev(result2.getInt("count"));
				teams.add(team);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return teams;
	}
	
	public static void addEmployee(Employee employee) {
		try 
		{ 
			 Connection connection = DBConnection.getConnection();
			 
			 PreparedStatement preparedStatement = connection
					  .prepareStatement("INSERT INTO employee (employee_id,first_name,last_name,address,phone,email,password,employee_rule) VALUES (?,?,?,?,?,?,?,?)");
			 preparedStatement.setInt(1, employee.getEmployeeID());
			 preparedStatement.setString(2, employee.getFirstName());
			 preparedStatement.setString(3, employee.getLastName());
			 preparedStatement.setString(4, employee.getaddres());
			 preparedStatement.setInt(5, employee.getPhone());
			 preparedStatement.setString(6, employee.getEmail());
			 preparedStatement.setString(7, employee.getPassword());
			 preparedStatement.setString(8, employee.getEmployeeRule());
			
			 
			 preparedStatement.executeUpdate();

		   
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static void addEmployeeTeam(int teamID,int developerID) {
		try 
		{ 
			 Connection connection = DBConnection.getConnection();
	 
			 PreparedStatement preparedStatement2 = connection
					  .prepareStatement("INSERT INTO employee_team (employee_id,team_id) VALUES (?,?)");
			 preparedStatement2.setInt(1, developerID);
			 preparedStatement2.setInt(2, teamID);
	
			 preparedStatement2.executeUpdate();
	   
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static void addTeam(int teamLeaderID, String teamName) {
		Random random = new Random();
		int randomNum =  random.nextInt(100000000);
		try 
		{ 
			 Connection connection = DBConnection.getConnection();
			 
			 PreparedStatement preparedStatement = connection
					  .prepareStatement("INSERT INTO team (team_id,team_leader_id,team_name) VALUES (?,?,?)");
			 preparedStatement.setInt(1, randomNum);
			 preparedStatement.setInt(2, teamLeaderID);
			 preparedStatement.setString(3, teamName);
	
			 preparedStatement.executeUpdate();
	   
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static Employee setEmployee(ResultSet result ) throws SQLException{
		Employee employee=new Employee();
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setPhonne(result.getInt("phone"));
		employee.setaddres(result.getString("address"));
		employee.setEmployeeID(result.getInt("employee_id"));
		employee.setEmployeeRule(result.getString("employee_rule"));
		employee.setEmail(result.getString("email"));
		employee.setPassword(result.getString("password"));
		
		return employee;
	}
}
