package com.asint.assignment3.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.asint.assignment3.model.Sale;

public interface SaleRepo extends JpaRepository<Sale, Integer> {

	
	@Query("select s.productId, sum(s.quantity)*p.price, p.name from Sale s join Product p on s.productId = p.id group by s.productId order by sum(s.quantity) desc")
	public List<Object[]> getProductWithTotalQuanity();
}
