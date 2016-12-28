package com.chappal.foot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Products 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int products_Id;
	private int category_Id;
	private int subcategory_Id;
	private int supplier_Id;
	private int brand_Id;
	private String products_Description;
	private String products_Name;
	private String products_Quantity;
	
	@NotEmpty(message="Name Cannot be Null")
	@Pattern(regexp="[0-9]+", message="Invalid Number Format")
	private String products_Price;
	
	@NotEmpty(message="Name Cannot be Null")
	@Pattern(regexp="[0-9]+", message="Invalid Number Format")
	private String products_Discount;
	
	@Transient
	private MultipartFile products_Image;
	
	@ManyToOne
	@JoinColumn(name="category_Id", nullable=false, updatable=false,insertable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="subcategory_Id", nullable=false, updatable=false,insertable=false)
	private SubCategory subcategory;
	
	@ManyToOne
	@JoinColumn(name="supplier_Id", nullable=false, updatable=false,insertable=false)
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="brand_Id", nullable=false, updatable=false,insertable=false)
	private Brand brand;
	
	public String getProducts_Quantity() {
		return products_Quantity;
	}

	public void setProducts_Quantity(String products_Quantity) {
		this.products_Quantity = products_Quantity;
	}

	public String getProducts_Price() {
		return products_Price;
	}

	public void setProducts_Price(String products_Price) {
		this.products_Price = products_Price;
	}

	public String getProducts_Discount() {
		return products_Discount;
	}

	public void setProducts_Discount(String products_Discount) {
		this.products_Discount = products_Discount;
	}


	public int getProducts_Id() {
		return products_Id;
	}

	public void setProducts_Id(int products_Id) {
		this.products_Id = products_Id;
	}

	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public int getSubcategory_Id() {
		return subcategory_Id;
	}

	public void setSubcategory_Id(int subcategory_Id) {
		this.subcategory_Id = subcategory_Id;
	}

	public int getSupplier_Id() {
		return supplier_Id;
	}

	public void setSupplier_Id(int supplier_Id) {
		this.supplier_Id = supplier_Id;
	}

	public int getBrand_Id() {
		return brand_Id;
	}

	public void setBrand_Id(int brand_Id) {
		this.brand_Id = brand_Id;
	}

	public String getProducts_Description() {
		return products_Description;
	}

	public void setProducts_Description(String products_Description) {
		this.products_Description = products_Description;
	}

	public String getProducts_Name() {
		return products_Name;
	}

	public void setProducts_Name(String products_Name) {
		this.products_Name = products_Name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public MultipartFile getProducts_Image() {
		return products_Image;
	}

	public void setProducts_Image(MultipartFile products_Image) {
		this.products_Image = products_Image;
	}

}
