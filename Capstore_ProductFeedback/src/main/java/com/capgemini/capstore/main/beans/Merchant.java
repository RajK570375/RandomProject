package com.capgemini.capstore.main.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MerchantDetail", uniqueConstraints = { @UniqueConstraint(columnNames = { "email", "mobileNo" }) })
@SequenceGenerator(name = "mercseq", initialValue = 2000, allocationSize = 100)
public class Merchant {

	@Id
	@Column(name = "merchantId")
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mercseq")
	private int merchantId;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotNull
	private User user;
	@Column(name = "merchantName")
	@NotNull
	private String merchantName;
	@Column(name = "email")
	@NotNull
	private String merchantEmail;
	@Column(name = "mobileNo")
	@NotNull
	private String merchantMobileNumber;
	@OneToOne
	@NotNull
	private Address merchantAddress;
	@Column(name = "storeName")
	private String merchantStoreName;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products;

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantEmail() {
		return merchantEmail;
	}

	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}

	public String getMerchantMobileNumber() {
		return merchantMobileNumber;
	}

	public void setMerchantMobileNumber(String merchantMobileNumber) {
		this.merchantMobileNumber = merchantMobileNumber;
	}

	public Address getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(Address merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public String getMerchantStoreName() {
		return merchantStoreName;
	}

	public void setMerchantStoreName(String merchantStoreName) {
		this.merchantStoreName = merchantStoreName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((merchantAddress == null) ? 0 : merchantAddress.hashCode());
		result = prime * result + ((merchantEmail == null) ? 0 : merchantEmail.hashCode());
		result = prime * result + merchantId;
		result = prime * result + ((merchantMobileNumber == null) ? 0 : merchantMobileNumber.hashCode());
		result = prime * result + ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result + ((merchantStoreName == null) ? 0 : merchantStoreName.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merchant other = (Merchant) obj;
		if (merchantAddress == null) {
			if (other.merchantAddress != null)
				return false;
		} else if (!merchantAddress.equals(other.merchantAddress))
			return false;
		if (merchantEmail == null) {
			if (other.merchantEmail != null)
				return false;
		} else if (!merchantEmail.equals(other.merchantEmail))
			return false;
		if (merchantId != other.merchantId)
			return false;
		if (merchantMobileNumber == null) {
			if (other.merchantMobileNumber != null)
				return false;
		} else if (!merchantMobileNumber.equals(other.merchantMobileNumber))
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (merchantStoreName == null) {
			if (other.merchantStoreName != null)
				return false;
		} else if (!merchantStoreName.equals(other.merchantStoreName))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
   
	
}
