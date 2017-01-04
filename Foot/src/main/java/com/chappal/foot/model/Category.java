package com.chappal.foot.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.google.gson.annotations.Expose;

@Entity
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	@Size(min = 15,message="Minimum 15 Characters Required")
	@Expose
	private String categoryDescription;
	@Pattern(regexp="[a-zA-Z]{1}+[a-zA-Z0-9]+", message="Invalid Name Format")
	@Expose
	private String categoryName;
	
	
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
	private Set<SubCategory> subCategory;

	public Set<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Set<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
