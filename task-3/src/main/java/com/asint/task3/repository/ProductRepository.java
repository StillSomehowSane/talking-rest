package com.asint.task3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asint.task3.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p.id, "
			+ "	   p.name, "
			+ "    p.price, "
			+ "    SUM(s.quantity) "
			+ "	   		FROM Sale s "
			+ "			LEFT JOIN Product p "
			+ "				ON p.id = s.productId "
			+ "			GROUP BY s.productId "
			+ "			ORDER BY SUM(s.quantity) DESC")
	public List<String[]> aggregateSales();
}
