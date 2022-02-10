package com.asint.task3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asint.task3.model.PopularProduct;
import com.asint.task3.repository.ProductRepository;

@RestController
public class ProductSalesController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/myApp/api/v1/products/popular")
	public List<PopularProduct> getPopularProducts() {
		List<String[]> aggregatedData = this.productRepository.aggregateSales();
		
		List<PopularProduct> products = new ArrayList<PopularProduct>();
		
		for (String[] data: aggregatedData) {
			
			PopularProduct product = new PopularProduct();
			product.setId(Integer.valueOf(data[0]));
			product.setName(data[1]);
			product.setTotalValue(Float.valueOf(data[2]) * Integer.valueOf(data[3]));
			
			products.add(product);
		}
		
		return products;
	}
}
