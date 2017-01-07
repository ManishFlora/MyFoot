package com.chappal.foot.daointerface;

import java.util.List;

import com.chappal.foot.model.Products;;

public interface ProductsDAO 
{
	public void addProducts(Products products);
	public List<Products> retriveProducts();
	public Products retriveProducts(String products_Id);
	public void deleteProducts(String products_Id);
	public int retriveCount();
	public String generateId();
}
