package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class BillingAddress 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int billingAddressId;
	@NotEmpty(message="Field is Required")
	@Expose
	private String flatNumber;
	@Size(min = 15,message="Minimum 15 Characters Required")
	@Expose
	private String streetAddress;
	@NotEmpty(message="Field is Required")
	@Expose
	private String city;
	@NotEmpty(message="Field is Required")
	@Expose
	private String state;
	@NotEmpty(message="Field is Required")
	@Expose
	private String country;
	@Pattern(regexp="[0-9]+", message="Invalid Number Format")
	@Expose
	private String zipCode;
	
	@OneToOne
	private UserDetail userDetail;

	public int getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}	
}
