package com.capgemini.capstore.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.main.beans.ProductFeedback;
import com.capgemini.capstore.main.service.CapstoreService;

@RestController
public class CapStoreController {
	
	@Autowired
	CapstoreService capstoreService;

	@RequestMapping(value="/addFeedback",method=RequestMethod.POST)
	public ProductFeedback setProductFeedback(@RequestBody ProductFeedback productFeedBack)
	{
		return capstoreService.setFeedback(productFeedBack);
	}
	
	@RequestMapping(value="/updateFeedback", method = RequestMethod.PUT)
	public ProductFeedback updateProductFeedback(@RequestBody ProductFeedback productFeedback)
	{
		return capstoreService.updateProductFeedBack(productFeedback);
	}
	
	@RequestMapping(value="/getAll/{product_Id}",  method = RequestMethod.GET)
	public List<ProductFeedback> showAllProductFeedback(@PathVariable int product_Id)
	{
		return capstoreService.getAll(product_Id);
	}
}
