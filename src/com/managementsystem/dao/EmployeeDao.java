package com.managementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.managementsystem.constant.Constant.*;
import com.managementsystem.DBConnection.DBConnection;
import com.managementsystem.model.Employee;
import com.managementsystem.model.Team;

public class EmployeeDao {
	private static Connection connection = DBConnection.getConnection();
  
	public static List<Employee> AllEmployee() {
		List<Employee> employees = new ArrayList<>();
		try 
		{ 
			PreparedStatement preparedStatement = connection
					  .prepareStatement("select * from employee where employee_rule=? or employee_rule=?");
			preparedStatement.setString(1, "Developer");
			preparedStatement.setString(2, "TeamLeader");
			
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
	
	public static List<Employee> AllDevloper() {
		List<Employee> employees = new ArrayList<>();
		try 
		{ 
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
	
	public static String employeeType(int employeeID) {
		String type="";
		try 
		{ 
			PreparedStatement preparedStatement = connection
					.prepareStatement("select employee_rule from employee where employee_id =?");
			preparedStatement.setInt(1, employeeID);	
			ResultSet result = preparedStatement.executeQuery();
			
			while (result.next()) {
				type=result.getString(EMPLOYEE_RULE);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return type;
	}
	
	public static List<Team> Team() {
		List<Team> teams = new ArrayList<>();
		try
		{
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
	
	public static void deleteEmplyee(int id) {
		try 
		{ 
			String type=employeeType(id);
			if(type.equals("Developer")) {
				deleteDeveloper(id);
			}
			else if(type.equals("TeamLeader")) {
				deleteTeamLeader(id);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
    public static void deleteDeveloper(int id){
		try
		{
			PreparedStatement preparedStatement1 = connection.prepareStatement("delete from task where employee_id=?");
			preparedStatement1.setInt(1, id);	
			preparedStatement1.executeUpdate();
			 
			PreparedStatement preparedStatement2 = connection.prepareStatement("delete from employee_team where employee_id=?");
			preparedStatement2.setInt(1, id);
			preparedStatement2.executeUpdate();
			 
			PreparedStatement preparedStatement3 = connection.prepareStatement("delete from employee where employee_id=?");
			preparedStatement3.setInt(1, id);
			preparedStatement3.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	

	public static void deleteTeamLeader(int id){
		try
		{
			PreparedStatement preparedStatement1 = connection.prepareStatement("delete from task where employee_id=?");
			preparedStatement1.setInt(1, id);	
			preparedStatement1.executeUpdate();
			 
			PreparedStatement preparedStatement2 = connection
					.prepareStatement("select team_id from team where team_leader_id =?");
			preparedStatement2.setInt(1, id);	
			ResultSet result = preparedStatement2.executeQuery();
			int teamID=0;
			while (result.next()) {
				teamID=result.getInt("team_id");
			}
			PreparedStatement preparedStatement3 = connection.prepareStatement("delete from employee_team where team_id=?");
			preparedStatement3.setInt(1, teamID);
			preparedStatement3.executeUpdate();
			
			PreparedStatement preparedStatement4 = connection.prepareStatement("delete from team where team_leader_id=?");
			preparedStatement4.setInt(1, id);
			preparedStatement4.executeUpdate();
			 
			PreparedStatement preparedStatement5 = connection.prepareStatement("delete from employee where employee_id=?");
			preparedStatement5.setInt(1, id);
			preparedStatement5.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static Employee setEmployee(ResultSet result ) throws SQLException {
		Employee employee=new Employee();
		employee.setFirstName(result.getString(FIRST_NAME));
		employee.setLastName(result.getString(LAST_NAME));
		employee.setPhonne(result.getInt(PHONE));
		employee.setaddres(result.getString(ADDRESS));
		employee.setEmployeeID(result.getInt(EMPLOYEE_ID));
		employee.setEmployeeRule(result.getString(EMPLOYEE_RULE));
		employee.setEmail(result.getString(EMAIL));
		employee.setPassword(result.getString(PASSWORD));
		
		return employee;
	}

}
