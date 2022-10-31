package com.amar.learnspringframework.enterprise.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amar.learnspringframework.enterprise.Data.DataService;

@Component
public class BusinessService {
	@Autowired
	private DataService dataService;

	public long calculate() {
		List<Integer> data = dataService.getData();
		return data.stream().reduce(Integer::sum).get(); 
		 
	}

}
