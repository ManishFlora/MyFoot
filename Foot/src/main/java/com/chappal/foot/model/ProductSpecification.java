package com.chappal.foot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.google.gson.annotations.Expose;

@Entity
public class ProductSpecification 
{
	@Id
	@Expose
	private String productsId;
	@Expose
	private String productColor;
	@Expose
	private String productDesign;
	@Expose
	private String productLast;
	@Expose
	private String productUpper;
	@Expose
	private String productLinning;
	@Expose
	private String productSole;
	@Expose
	private String productHeel;
	@Expose
	private int productSize;
	
	@OneToOne
	@JoinColumn(nullable=false,updatable=false,insertable=false, name="productsId")
	private Products products;
	
	@Transient
	private List<MultipartFile> productImages;

	public String getProductsId() {
		return productsId;
	}

	public void setProductsId(String productsId) {
		this.productsId = productsId;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getProductDesign() {
		return productDesign;
	}

	public void setProductDesign(String productDesign) {
		this.productDesign = productDesign;
	}

	public String getProductLast() {
		return productLast;
	}

	public void setProductLast(String productLast) {
		this.productLast = productLast;
	}

	public String getProductUpper() {
		return productUpper;
	}

	public void setProductUpper(String productUpper) {
		this.productUpper = productUpper;
	}

	public String getProductLinning() {
		return productLinning;
	}

	public void setProductLinning(String productLinning) {
		this.productLinning = productLinning;
	}

	public String getProductSole() {
		return productSole;
	}

	public void setProductSole(String productSole) {
		this.productSole = productSole;
	}

	public String getProductHeel() {
		return productHeel;
	}

	public void setProductHeel(String productHeel) {
		this.productHeel = productHeel;
	}

	public int getProductSize() {
		return productSize;
	}

	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public List<MultipartFile> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<MultipartFile> productImages) {
		this.productImages = productImages;
	}
	
	
}
