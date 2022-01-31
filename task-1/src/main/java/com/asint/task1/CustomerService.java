package com.asint.task1;

//import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService {

	@Autowired
	ResourceLoader resourceLoader;
	
	public List<CustomerBean> getAndSanitizeCustomers() {
		
		try {
			Resource resource = this.resourceLoader.getResource("file:C:\\Users\\ashwe\\Documents\\GitHub\\task-1\\src\\main\\resources\\static\\Customer.json");
			InputStream input = resource.getInputStream();
			
			ObjectMapper mapper = new ObjectMapper();
			
			List<CustomerBean> customers = Arrays.asList(mapper.readValue(input, CustomerBean[].class));
			
			Set<CustomerBean> tempS = new HashSet<CustomerBean>();
			tempS.addAll(customers);
			
			customers = new ArrayList<CustomerBean>();
			customers.addAll(tempS);
			
			return customers;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
