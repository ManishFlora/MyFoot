package com.chappal.foot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ProductSpecification 
{
	@Id
	private int products_Id;
	private String color;
	private String design;
	private String last;
	private String upper;
	private boolean linning;
	private boolean sole;
	private boolean heel;
	private int size;

	@OneToOne
	@JoinColumn(nullable=false,updatable=false,insertable=false, name="products_Id")
	private Products products;

	public int getProducts_Id() {
		return products_Id;
	}

	public void setProducts_Id(int products_Id) {
		this.products_Id = products_Id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getUpper() {
		return upper;
	}

	public void setUpper(String upper) {
		this.upper = upper;
	}

	public boolean isLinning() {
		return linning;
	}

	public void setLinning(boolean linning) {
		this.linning = linning;
	}

	public boolean isSole() {
		return sole;
	}

	public void setSole(boolean sole) {
		this.sole = sole;
	}

	public boolean isHeel() {
		return heel;
	}

	public void setHeel(boolean heel) {
		this.heel = heel;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
	
}
