package com.asint.assignment2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
public class ProductService {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	public List<ProductBean> getAndSanitizeProducts() {
		
		try {
			Resource resource = this.resourceLoader.getResource("file:C:\\Users\\Divya Khatri\\eclipse-workspace\\assignment2\\src\\main\\resources\\static\\Product.json");
			InputStream input = resource.getInputStream();
			
			ObjectMapper mapper = new ObjectMapper();
			
			List<ProductBean> products = Arrays.asList(mapper.readValue(input, ProductBean[].class));
			
			/*Set<ProductBean> tempS = new HashSet<ProductBean>();
			tempS.addAll(products);
			
			products = new ArrayList<ProductBean>();
			products.addAll(tempS); */
			
			return products;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<ProductBean> getFilteredProducts(String searchString, Boolean active) {
		List<ProductBean> products = getAndSanitizeProducts();
		
		List<ProductBean> filteredProducts = new ArrayList<ProductBean>();
		
		for(ProductBean item : products) {
			  if (item.getProductName().contains(searchString) && item.getIsActive() == active) {
				  filteredProducts.add(item);
			  }
		}
		
		return filteredProducts;
	}
	
	public Float getTotalProductPrices(List<ProductBean> ps) {
		Float total = 0.0f;
		
		for(ProductBean p : ps) { 
			total = total + p.getFloatPrice();
		}
		
		return total;
	}

}
