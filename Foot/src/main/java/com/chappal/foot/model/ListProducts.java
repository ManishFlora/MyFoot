package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.google.gson.annotations.Expose;

@Entity
public class ListProducts 
{
	@Id
	@Expose
	private String productsId;
	@Expose
	private String brandId;
	@Expose
	private String categoryId;
	@Expose
	private String subCategoryId;
	@Expose
	private String supplierId;
	@Expose 
	private String productsDescription;
	@Expose
	private int productsDiscount;
	@Expose
	private String productsName;
	@Expose
	private int productsPrice;
	@Expose
	private int productsQuantity;
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
	@Expose
	private String brandName;
	@Expose
	private String supplierName;
	@Expose
	private String subCategoryName;
	@Expose
	private String categoryName;
	
	public String getProductsId() {
		return productsId;
	}
	public void setProductsId(String productsId) {
		this.productsId = productsId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getProductsDescription() {
		return productsDescription;
	}
	public void setProductsDescription(String productsDescription) {
		this.productsDescription = productsDescription;
	}
	public int getProductsDiscount() {
		return productsDiscount;
	}
	public void setProductsDiscount(int productsDiscount) {
		this.productsDiscount = productsDiscount;
	}
	public String getProductsName() {
		return productsName;
	}
	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}
	public int getProductsPrice() {
		return productsPrice;
	}
	public void setProductsPrice(int productsPrice) {
		this.productsPrice = productsPrice;
	}
	public int getProductsQuantity() {
		return productsQuantity;
	}
	public void setProductsQuantity(int productsQuantity) {
		this.productsQuantity = productsQuantity;
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
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}	
}