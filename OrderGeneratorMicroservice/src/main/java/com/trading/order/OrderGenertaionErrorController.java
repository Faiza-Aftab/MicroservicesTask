package com.trading.order;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utility.OrderGenerationConstants;

@Controller
public class OrderGenertaionErrorController implements ErrorController {



	@RequestMapping(OrderGenerationConstants.Error_Path)
	@ResponseBody
	public String handleError(HttpServletResponse response) {
		
		String errorMessage=   "";
		if(response.getStatus()== HttpStatus.BAD_REQUEST.value())
			errorMessage = OrderGenerationConstants.ErrorMessage_BadRequest;
		
		else if (response.getStatus()== HttpStatus.NOT_FOUND.value())
			errorMessage = OrderGenerationConstants.ErrorMessage_NOService;
			
		System.out.println(errorMessage);
		return errorMessage;
	}

	@Override
	public String getErrorPath() {
		return OrderGenerationConstants.Error_Path;
	}
}
