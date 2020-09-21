package com.domain.object;

public class Order {

	private long orderId;
	private String symbol;
	private  int quantity;
	private double orderExceutionPrice;
	
	public Order(){}
	
	Order(long orderId, String symbol, int quantity, double orderExceutionPrice)
	{
		this.orderId= orderId;
		this.symbol = symbol;
		this.quantity=quantity;
		this.orderExceutionPrice=orderExceutionPrice;
	}
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getOrderExceutionPrice() {
		return orderExceutionPrice;
	}

	public void setOrderExceutionPrice(double orderExceutionPrice) {
		this.orderExceutionPrice = orderExceutionPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", symbol=" + symbol + ", quantity=" + quantity + ", orderExceutionPrice="
				+ orderExceutionPrice + "]";
	}
	
	

}
