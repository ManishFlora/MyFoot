package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BillingAddress 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int billingAddress_Id;
	@NotEmpty
	private String flat_Number;
	@NotEmpty
	private String street_Address;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String country;
	@NotEmpty
	@Pattern(regexp="[0-9]+")
	private String zip_Code;
	
	@OneToOne
	private UserDetail userDetail;

	public int getBillingAddress_Id() {
		return billingAddress_Id;
	}

	public void setBillingAddress_Id(int billingAddress_Id) {
		this.billingAddress_Id = billingAddress_Id;
	}

	public String getFlat_Number() {
		return flat_Number;
	}

	public void setFlat_Number(String flat_Number) {
		this.flat_Number = flat_Number;
	}

	public String getStreet_Address() {
		return street_Address;
	}

	public void setStreet_Address(String street_Address) {
		this.street_Address = street_Address;
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

	public String getZip_Code() {
		return zip_Code;
	}

	public void setZip_Code(String zip_Code) {
		this.zip_Code = zip_Code;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	
	
}
