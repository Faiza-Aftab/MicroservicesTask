package com.trading.order;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.domain.object.Order;
import com.utility.OrderGenerationConstants;

@RestController
public class OrderGeneratorController{
    
	    
    @GetMapping("/order-generator/symbol/{symbol}/quantity/{quantity}")
    public Object generateNewOrder(@PathVariable String symbol, @PathVariable int quantity) {
    
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("symbol", symbol);
    uriVariables.put("quantity", quantity+"");
    
    Order response = new  RestTemplate().getForObject(
    		OrderGenerationConstants.OrderProcessingService_URL, Order.class,
            uriVariables);
    
    System.out.println("New order generated:	"+ response.toString());
    
    return response;
   }
    
}
