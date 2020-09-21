package com.tradingorder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;

import com.trading.order.OrderProcessorApplication;


@SpringBootTest(classes = OrderProcessorApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)

class IntegrationTest_OrderProcessingMetrics {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();
	
	@Test
	void Test_showMetrics() {
		String metrics = restTemplate.getForObject(createURLWithPort("/order-processor-metrics"), String.class);

		assert (metrics != null && metrics.length() != 0);

	}


	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
