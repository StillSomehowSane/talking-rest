package com.asint.assignment1;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



@RestController
public class CustomerController {

	
	@RequestMapping(value="/myapp/api/v1/customers",method=RequestMethod.GET)  
	public JSONArray data() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		JSONArray customers = (JSONArray) parser.parse(new FileReader("C:\\Users\\Divya Khatri\\Downloads\\Customer.json"));
		
		JSONArray filteredCustomers = new JSONArray();
		HashMap<String, Boolean> visitedCustomerIdMap = new HashMap<>();

		//visitedCustomerIdMap = {}
		for (Object customerObject : customers) {
			 JSONObject  customerJson  = (JSONObject) customerObject; //typecasting
			 String customerId = (String) customerJson.get("CustomerID");//key value pair 
			 
			 //customerId = "MYID0",
			 if (!visitedCustomerIdMap.containsKey(customerId)) {
				 filteredCustomers.add(customerObject);
				 visitedCustomerIdMap.put(customerId, true);
			 }
			 
			 //visitedCustomerIdMap -> {"MYID0": true, "MYID1": true}

		}
		
		return filteredCustomers;
		
	}
}
