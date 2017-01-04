package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class Brand 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brandId;
	@Size(min = 15,message="Minimum 15 Characters Required")
	@Expose
	private String brandDescription;
	@Pattern(regexp="[a-zA-Z_ ]{1}+[a-zA-Z0-9_ ]+", message="Invalid Name Format")
	@Expose
	private String brandName;
	
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandDescription() {
		return brandDescription;
	}
	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
		
}
