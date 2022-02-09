package com.asint.assignment3.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asint.assignment3.model.Product;
import com.asint.assignment3.repository.ProductRepo;
import com.asint.assignment3.repository.SaleRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class ProductService {
	@Autowired SaleRepo saleRepo;
	@Autowired ProductRepo productRepo;
	@Autowired ObjectMapper mapper;

	public ArrayNode getProductWithTotalQuanityResponse() {
		List<Object[]> data = saleRepo.getProductWithTotalQuanity();
		
		//[[4,587],[6,426],[1,399],[8,280],[7,225],[2,158],[3,116],[5,66]]
		
		ArrayNode arrayNode = mapper.createArrayNode();
		for(Object[] o : data ) {
			ObjectNode objectNode = mapper.createObjectNode();
			
			objectNode.put("id", (Integer) o[0]);
			objectNode.put("name", (String) o[2]);
			objectNode.put("total_value", (Float) o[1]);
			
//			Optional<Product> dbProduct = productRepo.findById(o[0]);
//			dbProduct.ifPresent(existingProduct -> {
//			    objectNode.put("name", existingProduct.getName());
//			    objectNode.put("total_value", o[1]*existingProduct.getPrice());
//			});
			
			arrayNode.add(objectNode);
		}
		
		return arrayNode;
	}
}
