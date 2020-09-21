package com.trading.order;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.object.Order;

@Service
public class OrderProcessing {

	@Autowired
	private OrderProcessorRepository orderRepository;

	 Order processOrder(String symbol, int quantity) {

		double price = calculateOrderExecutionPrice(quantity);
		long id = orderRepository.persistOrder(symbol, quantity, price);

		Order order = new Order();
		order.setOrderId(id);
		order.setSymbol(symbol);
		order.setQuantity(quantity);
		order.setOrderExceutionPrice(price);
		
		return order;
	}

	private double calculateOrderExecutionPrice(int quantity) {

		double price = getRandomNumber(1.1, 2.0) * quantity;
		
		return new BigDecimal(price).setScale(4, RoundingMode.HALF_UP).doubleValue();
	}

	private double getRandomNumber(double min, double max) {
		
		//generate a random number between min and max
		return  ((Math.random() * (max - min)) + min);
	}

	 String getOrderMetrics() {

		String[] result =  orderRepository.getOrderMetrics();
		
		String metrics =  "Total count of processed orders: " + result[0]+
				"\nAverage order execution price: "+ result[1];
		
		System.out.println(metrics);
		
		return metrics;
		
	}

}
