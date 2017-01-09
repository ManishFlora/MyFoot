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
	private String color;
	@Expose
	private String size;
	@Expose
	private String material;
	@Expose
	private String style;
	@Expose
	private String supportSystem;
	@Expose
	private String weight;
	@Expose
	private String dimensions;
	@Expose
	private String waranty;
	@Expose
	private String detail;
	@Expose
	private String shoeWidth;
	@Expose
	private String season;
	@Expose
	private String sole;
	
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSupportSystem() {
		return supportSystem;
	}

	public void setSupportSystem(String supportSystem) {
		this.supportSystem = supportSystem;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getWaranty() {
		return waranty;
	}

	public void setWaranty(String waranty) {
		this.waranty = waranty;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getShoeWidth() {
		return shoeWidth;
	}

	public void setShoeWidth(String shoeWidth) {
		this.shoeWidth = shoeWidth;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getSole() {
		return sole;
	}

	public void setSole(String sole) {
		this.sole = sole;
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
