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
@Table(name = "MerchantFeedback")
public class MerchantFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	@NotNull
	private Feedback feedback;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Merchant merchant;
	@Column(name = "feedbackComment")
	private String merchantFeedback;
	@Column(name = "rating")
	@Max(5)
	@Min(0)
	private int rating;

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public String getMerchantFeedback() {
		return merchantFeedback;
	}

	public void setMerchantFeedback(String merchantFeedback) {
		this.merchantFeedback = merchantFeedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
