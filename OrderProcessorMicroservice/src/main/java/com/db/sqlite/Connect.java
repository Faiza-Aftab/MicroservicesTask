package com.db.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

//Connect to a Trading orders database
	public static Connection getConnection() {
		Connection conn = null;
		try {
			
			// create a connection to the database
			conn = DriverManager.getConnection(SQL_Constants.DATABASE_URL);

			//System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
