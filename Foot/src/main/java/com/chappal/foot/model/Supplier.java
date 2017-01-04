package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class Supplier 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	@Size(min = 15,message="Minimum 15 Characters Required")
	@Expose
	private String supplierAddress;
	@Pattern(regexp="[a-zA-Z]{1}+[a-zA-Z0-9]+", message="Invalid Name Format")
	@Expose
	private String supplierName;
	@Pattern(regexp=".+@.+\\..+", message="Invalid EmailID")
	@Expose
	private String supplierEmailId;
	@Pattern(regexp="[0-9]+", message="Invalid Number Format")
	@Expose
	private String supplierPhoneNumber;
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierEmailId() {
		return supplierEmailId;
	}
	public void setSupplierEmailId(String supplierEmailId) {
		this.supplierEmailId = supplierEmailId;
	}
	public String getSupplierPhoneNumber() {
		return supplierPhoneNumber;
	}
	public void setSupplierPhoneNumber(String supplierPhoneNumber) {
		this.supplierPhoneNumber = supplierPhoneNumber;
	}
	
}
