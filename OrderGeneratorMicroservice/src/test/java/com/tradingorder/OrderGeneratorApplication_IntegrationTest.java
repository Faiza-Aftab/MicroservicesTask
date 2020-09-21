package com.tradingorder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.domain.object.Order;
import com.trading.order.OrderGeneratorApplication;

@SpringBootTest(classes = { OrderGeneratorApplication.class, Order.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
class OrderGeneratorApplication_IntegrationTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate testRestTemplate;

	HttpHeaders headers = new HttpHeaders();

	@Test
	void Test_GenerateNewOrder() {

		
		Order order = testRestTemplate.getForObject(
				createURLWithPort("order-generator/symbol/RIMI/quantity/800"), Order.class);
				
		assert (order != null);

	}
	
	@Test
	void Test_GenerateNewOrder_InvalidInputParameters() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		//Quantity should be an integer value
		ResponseEntity<String> response = testRestTemplate.exchange(
				createURLWithPort("order-generator/symbol/ORACLE/quantity/AD90"),
				HttpMethod.GET, entity, String.class);

		assert (response.getStatusCodeValue() == HttpStatus.BAD_REQUEST.value());

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
