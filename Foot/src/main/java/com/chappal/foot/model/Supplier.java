package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Supplier 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplier_Id;
	private String supplier_Address;
	private String supplier_Name;
	private String supplier_EmailId;
	private String supplier_PhoneNumber;
	
	public int getSupplier_Id() {
		return supplier_Id;
	}
	public void setSupplier_Id(int supplier_Id) {
		this.supplier_Id = supplier_Id;
	}
	public String getSupplier_Address() {
		return supplier_Address;
	}
	public void setSupplier_Address(String supplier_Address) {
		this.supplier_Address = supplier_Address;
	}
	public String getSupplier_Name() {
		return supplier_Name;
	}
	public void setSupplier_Name(String supplier_Name) {
		this.supplier_Name = supplier_Name;
	}
	public String getSupplier_EmailId() {
		return supplier_EmailId;
	}
	public void setSupplier_EmailId(String supplier_EmailId) {
		this.supplier_EmailId = supplier_EmailId;
	}
	public String getSupplier_PhoneNumber() {
		return supplier_PhoneNumber;
	}
	public void setSupplier_PhoneNumber(String supplier_PhoneNumber) {
		this.supplier_PhoneNumber = supplier_PhoneNumber;
	}
}
