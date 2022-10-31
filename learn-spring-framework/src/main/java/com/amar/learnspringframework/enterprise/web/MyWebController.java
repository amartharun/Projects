package com.amar.learnspringframework.enterprise.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amar.learnspringframework.enterprise.Business.BusinessService;

@Component 
public class MyWebController {
	@Autowired
	private BusinessService businessService; 
	public long returnvaluefromBusinessService() {
		return businessService.calculate();
	}

}
