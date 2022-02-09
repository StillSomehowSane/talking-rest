package com.asint.assignment3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asint.assignment3.repository.ProductRepo;
import com.asint.assignment3.service.ProductService;
import com.fasterxml.jackson.databind.node.ArrayNode;

@RestController
public class ProductController {
	
	@Autowired ProductRepo productRepo;
	@Autowired ProductService productService;
	
	@GetMapping("/myapp/api/v1/products/popular")
	public ArrayNode products()
	{
		return productService.getProductWithTotalQuanityResponse();
	}
	

}
