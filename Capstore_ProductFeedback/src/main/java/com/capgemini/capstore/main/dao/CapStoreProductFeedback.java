package com.capgemini.capstore.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.main.beans.Product;
import com.capgemini.capstore.main.beans.ProductFeedback;

@Repository
public interface CapStoreProductFeedback extends JpaRepository<ProductFeedback, Integer>{
	
//	@Query(value = "select * from Product_Feedback  where product_product_id = :product_Id", nativeQuery=true)
//	public List<ProductFeedback> getProduct(@Param(value = "product_Id") int product_Id);
	
//	public List<ProductFeedback> getProduct(int product_Id);

	public List<ProductFeedback> findByProduct(Product product);
}
