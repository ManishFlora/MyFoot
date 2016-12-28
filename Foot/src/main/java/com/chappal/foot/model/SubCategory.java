package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class SubCategory 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subcategory_Id;
	private String subcategory_Description;
	private String subcategory_Name;
	
	@ManyToOne
	@JoinColumn(name="category_Id", nullable=false, updatable=false,insertable=false)
	private Category category;

	private int category_Id;
	
	public int getSubcategory_Id() {
		return subcategory_Id;
	}

	public void setSubcategory_Id(int subcategory_Id) {
		this.subcategory_Id = subcategory_Id;
	}

	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public String getSubcategory_Description() {
		return subcategory_Description;
	}

	public void setSubcategory_Description(String subcategory_Description) {
		this.subcategory_Description = subcategory_Description;
	}

	public String getSubcategory_Name() {
		return subcategory_Name;
	}

	public void setSubcategory_Name(String subcategory_Name) {
		this.subcategory_Name = subcategory_Name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}