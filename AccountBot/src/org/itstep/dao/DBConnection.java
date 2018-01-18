package org.itstep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:postgresql://localhost:5432/ST21";
	private static final String USER_NAME = "postgres";
	private static final String USER_PASSWORD = "deniela35rus";
	
	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}