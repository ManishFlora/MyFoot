package com.chappal.foot.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.google.gson.annotations.Expose;

@Entity
public class SubCategory 
{
	@Id
	@Expose
	private String subCategoryId;
	@Size(min = 15,message="Minimum 15 Characters Required")
	@Expose
	private String subCategoryDescription;
	@Pattern(regexp="[a-zA-Z]{1}+[a-zA-Z0-9_ ]+", message="Invalid Name Format")
	@Expose
	private String subCategoryName;
	
	@ManyToOne
	@JoinColumn(name="categoryId", nullable=false, updatable=false,insertable=false)
	private Category category;
	
	@Expose
	private String categoryId;
	
	public String getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(String subcategoryId) {
		this.subCategoryId = subcategoryId;
	}

	public String getSubCategoryDescription() {
		return subCategoryDescription;
	}

	public void setSubCategoryDescription(String subcategoryDescription) {
		this.subCategoryDescription = subcategoryDescription;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subcategoryName) {
		this.subCategoryName = subcategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
		
}