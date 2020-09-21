package com.tradingorder;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.domain.object.Order;

@SpringBootTest(classes = OrderProcessorApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)

class IntegrationTest_OrderProcessing {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();

	@Test
	void Test_ProcessOrder() {

		Order order = restTemplate.getForObject(createURLWithPort("order-processor/symbol/ALEXA/quantity/909"),
				Order.class);

		assert (order != null);
	}

	@Test
	void Test_ProcessOrder_InvalidInputParameters() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		// Quantity should be an integer value
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("order-processor/symbol/TEST/quantity/TEST90"), HttpMethod.GET, entity, String.class);

		assert (response.getStatusCodeValue() == HttpStatus.BAD_REQUEST.value());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
