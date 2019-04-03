package com.capgemini.capstore.main.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ProductFeedback")
public class ProductFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Product product;
	@Column(name = "feedbackComment")
	private String productFeedback;
	@Column(name = "rating")
	@Max(5)
	@Min(0)
	private int rating;
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductFeedback() {
		return productFeedback;
	}

	public void setProductFeedback(String productFeedback) {
		this.productFeedback = productFeedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
