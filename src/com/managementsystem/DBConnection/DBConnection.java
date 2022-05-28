package com.managementsystem.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection conn = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/management_system?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"0595320479");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public static Connection getConnection() {
		return conn;
	}

}
