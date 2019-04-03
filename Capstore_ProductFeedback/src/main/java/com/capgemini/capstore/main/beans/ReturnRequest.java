package com.capgemini.capstore.main.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "ReturnRequest")
public class ReturnRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Merchant merchant;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Product product;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Order order;
	@Column(name = "refundAmount")
	@NotNull
	private double refundAmount;
	@Column(name = "returnStatus")
	@NotNull
	@Pattern(regexp="\\b(Applied|Approved|Rejected)\\b")
	private ReturnStatus returnStatus;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public ReturnStatus getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(ReturnStatus returnStatus) {
		this.returnStatus = returnStatus;
	}

}
