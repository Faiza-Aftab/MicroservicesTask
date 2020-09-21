package com.utility;

public class OrderGenerationConstants {

	public static final String Error_Path  ="/error";

	public static final String [] Order_Symbols = {"APPLE", "GOOGLE", "IBM", "YAHOO", "ORACLE", "AMAZON", "NETFLIX", "YAHOO"};
	public static final int [] Order_Quantities = {1, 5,10,15,20,25,30,35, 40, 100};
	
	public static final String OrderProcessingService_URL = "http://localhost:3001/order-processor/symbol/{symbol}/quantity/{quantity}";

	public static final String ErrorMessage_NOService =  "Order generation error: Service not available.";

	public static final String ErrorMessage_BadRequest = "Order generation error: Invalid input parameter(s).";
}
