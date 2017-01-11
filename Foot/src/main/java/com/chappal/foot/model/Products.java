package com.chappal.foot.model;


import java.util.List;

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
	@Expose
	private String productsId;
	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	@Expose
	private String categoryId;
	@Expose
	private String subcategoryId;
	@Expose
	private String supplierId;
	@Expose
	private String brandId;
	@Expose
	private double discountedPrice;
	@Expose
	private int productsQuantity;
	@Expose
	private int productsPrice;
	@Expose
	private double productsDiscount;
	@Size(min = 15,message="Minimum 15 Characters Required")
	@Expose
	private String productsDescription;
	
	@Pattern(regexp="[a-zA-Z_ ]{1}+[a-zA-Z0-9_ ]+", message="Invalid Name Format")
	@Expose
	private String productsName;
	
	@Transient
	private List<MultipartFile> productImages;
	
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

	public String getProductsId() {
		return productsId;
	}

	public void setProductsId(String productsId) {
		this.productsId = productsId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
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
	
	public List<MultipartFile> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<MultipartFile> productImages) {
		this.productImages = productImages;
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
