package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class ShippingAddress 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shippingAddressId;
	@NotEmpty(message="Field is Required")
	@Expose
	private String flatNumber;
	@NotEmpty(message="Field is Required")
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
	@NotEmpty(message="Field is Required")
	@Expose
	private String zipCode;
	
	@OneToOne
	private UserDetail userDetail;

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
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
