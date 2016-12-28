package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Brand 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brand_Id;
	private String brand_Description;
	private String brand_Name;
	
	public int getBrand_Id() {
		return brand_Id;
	}
	public void setBrand_Id(int brand_Id) {
		this.brand_Id = brand_Id;
	}
	public String getBrand_Description() {
		return brand_Description;
	}
	public void setBrand_Description(String brand_Description) {
		this.brand_Description = brand_Description;
	}
	public String getBrand_Name() {
		return brand_Name;
	}
	public void setBrand_Name(String brand_Name) {
		this.brand_Name = brand_Name;
	}
	
}
