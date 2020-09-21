package com.tradingorder;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.domain.object.Order;

@RestController
public class OrderProcessorController {

	@Autowired
	private OrderProcessing op;

	@GetMapping("/order-processor/symbol/{symbol}/quantity/{quantity}")
	public Order processOrder(@PathVariable String symbol, @PathVariable int quantity) {

		Order response = op.processOrder(symbol, quantity);

		return response;
	}

	@GetMapping("/order-processor-metrics")
	public String showMetrics() {

		return op.getOrderMetrics();

	}
}
