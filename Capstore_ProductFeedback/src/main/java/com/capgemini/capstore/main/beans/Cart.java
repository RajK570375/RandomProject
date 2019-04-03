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
@Table(name = "Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	@NotNull
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Product product;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Merchant merchant;
	@Column(name = "quantity")
	@NotNull
	private int quantity;
	@Column(name = "price")
	@NotNull
	private double productPrice;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private Promo promo;
	@Column(name = "softDelete")
	@NotNull
	@Pattern(regexp = "^[AI] {1}$")
	private SoftDelete softDelete;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}

	public SoftDelete getSoftDelete() {
		return softDelete;
	}

	public void setSoftDelete(SoftDelete softDelete) {
		this.softDelete = softDelete;
	}

}
