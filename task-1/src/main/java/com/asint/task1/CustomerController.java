package com.asint.task1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	CustomerService custService;
	
	@GetMapping("/task1/api/v1/customers")
	public List<CustomerBean> getCustomers() {
		
		return custService.getAndSanitizeCustomers();
	}
}
