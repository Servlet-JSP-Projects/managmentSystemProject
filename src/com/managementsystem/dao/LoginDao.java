package com.managementsystem.dao;

import static com.managementsystem.constant.Constant.ADDRESS;
import static com.managementsystem.constant.Constant.EMAIL;
import static com.managementsystem.constant.Constant.EMPLOYEE_ID;
import static com.managementsystem.constant.Constant.EMPLOYEE_RULE;
import static com.managementsystem.constant.Constant.FIRST_NAME;
import static com.managementsystem.constant.Constant.LAST_NAME;
import static com.managementsystem.constant.Constant.PASSWORD;
import static com.managementsystem.constant.Constant.PHONE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.managementsystem.DBConnection.DBConnection;
import com.managementsystem.model.Employee;
import com.managementsystem.model.Login;

public class LoginDao {

	private static Connection connection = DBConnection.getConnection();
	static Employee employee = new Employee();

	public static boolean validate(Login login) {
		boolean isValidate = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from employee where email = ? and password = ? ");
			preparedStatement.setString(1, login.getEmail());
			preparedStatement.setString(2, login.getPassword());
			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				isValidate = true;
				employee.setFirstName(result.getString(FIRST_NAME));
				employee.setLastName(result.getString(LAST_NAME));
				employee.setPhonne(result.getInt(PHONE));
				employee.setaddres(result.getString(ADDRESS));
				employee.setEmployeeID(result.getInt(EMPLOYEE_ID));
				employee.setEmployeeRule(result.getString(EMPLOYEE_RULE));
				employee.setEmail(result.getString(EMAIL));
				employee.setPassword(result.getString(PASSWORD));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return isValidate;
	}

	public static Employee getEmployee() {
		return employee;
	}
}
