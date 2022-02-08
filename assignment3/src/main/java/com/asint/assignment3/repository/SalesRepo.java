package com.asint.assignment3.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asint.assignment3.model.Sales;


public interface SalesRepo extends JpaRepository<Sales, Serializable> {

	
	@Query(value = "select product_id, sum(quantity) as quantity from sales group by product_id order by sum(quantity) desc", nativeQuery = true)
	public List<Integer[]> getProductWithTotalQuanity();
}
