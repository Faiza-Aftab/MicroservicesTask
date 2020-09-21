package com.trading.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.domain.object.Order;
import com.utility.OrderGenerationConstants;

@EnableScheduling
@Configuration
@ConditionalOnProperty(name = "spring.enable.scheduling")
public class ScheduleEnabling {

	// generate order after every 2 seconds
	@Scheduled(fixedRateString = "${sample.schedule.string}")
	public void scheduleTaskWithFixedRate() throws InterruptedException {
		generateOrders();
	}

	public void generateOrders() throws InterruptedException {

		Order order = getNewOrderData();

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("symbol", order.getSymbol());
		uriVariables.put("quantity", Integer.toString(order.getQuantity()));

		try {

			order = new RestTemplate().getForObject(OrderGenerationConstants.OrderProcessingService_URL, Order.class,
					uriVariables);

			// print newly generated order on console
			System.out.println("New order generated:	" + order.toString());
		} catch (Exception e) {
			System.out.println(
					"Order can not be sent to order processing microservice. As service may not be up or running.");
		}

	}

	private Order getNewOrderData() {

		Order o = new Order();
		o.setSymbol(getRandomSymbol());
		o.setQuantity(getRandomQuantity());

		return o;
	}

	private String getRandomSymbol() {
		int rnd = new Random().nextInt(OrderGenerationConstants.Order_Symbols.length);
		return OrderGenerationConstants.Order_Symbols[rnd];
	}

	private int getRandomQuantity() {
		int rnd = new Random().nextInt(OrderGenerationConstants.Order_Quantities.length);
		return OrderGenerationConstants.Order_Quantities[rnd];
	}

}
