package com.trading.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.db.sqlite.Connect;
import com.db.sqlite.SQL_Constants;

@Service
public class OrderProcessorRepository {

	int persistOrder(String symbol, int quantity, double price) {

		int orderid = -1;

		try {
			Connection conn = Connect.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(SQL_Constants.INSERT_ROW);
			ps.setString(1, symbol);
			ps.setInt(2, quantity);
			ps.setDouble(3, price);
			ps.execute();
			
			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(SQL_Constants.LAST_INSERTRED_ROW_ID);

			if (rs.next()) {
				orderid = rs.getInt(1);
			}
			
			Connect.closeConnection(conn);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	
		return orderid;
	}

	void createTable() {
		
		try {
			Connection conn = Connect.getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute(SQL_Constants.CREATE_TABLE);
			Connect.closeConnection(conn);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	
	}

	void dropTable() {
		
		try {
			Connection conn = Connect.getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute(SQL_Constants.DROP_TABLE);
			Connect.closeConnection(conn);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String[] getOrderMetrics() {
		String[] response = new String[2];

		try {
			Connection conn = Connect.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_Constants.COLOUMN_COUNT);
						
			if(rs.next()) {
			    response[0] = String.valueOf(rs.getInt(1));
			ResultSet rs1 = stmt.executeQuery(SQL_Constants.COLOUMN_AVG);
			
			if(rs1.next())
			    response[1] = String.valueOf(rs.getFloat(1));
            }
			Connect.closeConnection(conn);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return response;
	}

}
