package com.asint.assignment2;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class Response {
	public List<ProductBean> products;
	public Float total;
}

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/myapp/api/v1/products/{search_string}/list")
	public Response getProducts(@PathVariable String search_string,  @RequestParam(value = "active", required=false, defaultValue = "true") Boolean activeParam) {
	
		List<ProductBean> filteredProducts = productService.getFilteredProducts(search_string, activeParam);
		
		Float total = productService.getTotalProductPrices(filteredProducts);
		
		Response r = new Response();
		r.products = filteredProducts;
		r.total = total;
		
		return r; 
	}
	
	

	
	}


