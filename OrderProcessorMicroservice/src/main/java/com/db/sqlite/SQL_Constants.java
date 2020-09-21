package com.db.sqlite;

public class SQL_Constants {
	
	public static final String DATABASE_URL= "jdbc:sqlite:./src/main/resources/TradingOrders.db";
	
	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS orders("
			+ "orderid INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ "symbol TEXT NOT NULL, "
			+ "quantity INTEGER, "
			+ "order_exceution_price REAL);";
	
	public static final String DROP_TABLE= "DROP TABLE ORDERS";
	
	public static final String LAST_INSERTRED_ROW_ID= "SELECT last_insert_rowid()";
	
	public static final String INSERT_ROW= "INSERT INTO orders(symbol,quantity, order_exceution_price) VALUES (?,?,?)";

	public static final String COLOUMN_AVG= "SELECT AVG(order_exceution_price)FROM orders;";
	
	public static final String COLOUMN_COUNT= "SELECT COUNT(orderID)FROM orders;";
	
}
