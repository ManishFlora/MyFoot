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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.annotations.Expose;

@Entity
public class Products 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productsId;
	private int categoryId;
	private int subcategoryId;
	private int supplierId;
	private int brandId;
	@Size(min = 15,message="Minimum 15 Characters Required")
	@Expose
	private String productsDescription;
	@Pattern(regexp="[a-zA-Z]{1}+[a-zA-Z0-9]+", message="Invalid Name Format")
	@Expose
	private String productsName;
	@NotEmpty(message="Field is Required")
	@Expose
	private int productsQuantity;
	@Expose
	private int productsPrice;
	@Expose
	private double productsDiscount;
	
	@Expose
	@Transient
	private MultipartFile productsImage;
	
	@ManyToOne
	@JoinColumn(name="categoryId", nullable=false, updatable=false,insertable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="subcategoryId", nullable=false, updatable=false,insertable=false)
	private SubCategory subcategory;
	
	@ManyToOne
	@JoinColumn(name="supplierId", nullable=false, updatable=false,insertable=false)
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="brandId", nullable=false, updatable=false,insertable=false)
	private Brand brand;

	public int getProductsId() {
		return productsId;
	}

	public void setProductsId(int productsId) {
		this.productsId = productsId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getProductsDescription() {
		return productsDescription;
	}

	public void setProductsDescription(String productsDescription) {
		this.productsDescription = productsDescription;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public int getProductsQuantity() {
		return productsQuantity;
	}

	public void setProductsQuantity(int productsQuantity) {
		this.productsQuantity = productsQuantity;
	}

	public int getProductsPrice() {
		return productsPrice;
	}

	public void setProductsPrice(int productsPrice) {
		this.productsPrice = productsPrice;
	}

	public double getProductsDiscount() {
		return productsDiscount;
	}

	public void setProductsDiscount(double productsDiscount) {
		this.productsDiscount = productsDiscount;
	}

	public MultipartFile getProductsImage() {
		return productsImage;
	}

	public void setProductsImage(MultipartFile productsImage) {
		this.productsImage = productsImage;
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
	
}
