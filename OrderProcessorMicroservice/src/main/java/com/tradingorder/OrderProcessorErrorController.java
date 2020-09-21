package com.tradingorder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderProcessorErrorController implements ErrorController{
	
	public static final String PATH  ="/error";
	
	@RequestMapping(PATH)
	@ResponseBody
	public String handleError(HttpServletResponse response) {
		
		String errorMessage=   "";
		if(response.getStatus()== HttpStatus.BAD_REQUEST.value())
			errorMessage =  "Order processing error: Invalid input parameter(s).";
		else if (response.getStatus()== HttpStatus.NOT_FOUND.value())
			errorMessage =  "Order processing error: Service not available.";

		System.out.println(errorMessage);
		return errorMessage;
	}


	@Override
	public String getErrorPath() {
		return PATH;
	}
}
