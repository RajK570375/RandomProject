package com.capgemini.capstore.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.main.beans.ProductFeedback;
import com.capgemini.capstore.main.dao.CapStoreProduct;
import com.capgemini.capstore.main.dao.CapStoreProductFeedback;


@Transactional
@Service
public class CapstoreService {

	@Autowired
	private CapStoreProductFeedback capStoreFeedback;
	
	@Autowired
	private CapStoreProduct capStoreProduct;

	public ProductFeedback setFeedback(ProductFeedback productFeedback) {
	
		//entityManager.persist(feedback);
		capStoreFeedback.save(productFeedback);

		return productFeedback;

	}

	public List<ProductFeedback> getAll(int product_Id) {

//		List<ProductFeedback> product_feedback = new ArrayList<ProductFeedback>();
		
		List<ProductFeedback> product_feedback = capStoreFeedback.findByProduct(capStoreProduct.findById(product_Id).get());
        return product_feedback;
	}

	
	public ProductFeedback updateProductFeedBack(ProductFeedback productFeedback)
	{
		productFeedback = capStoreFeedback.getOne(productFeedback.getId());
		productFeedback.setProduct(productFeedback.getProduct());
		productFeedback.setRating(productFeedback.getRating());
		productFeedback.setProductFeedback(productFeedback.getProductFeedback());
		productFeedback.setId(productFeedback.getId());
		capStoreFeedback.save(productFeedback);
		return productFeedback;
	}
}
