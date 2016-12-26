package com.chappal.foot.daointerface;

import java.util.List;

import com.chappal.foot.model.Products;;

public interface ProductsDAO 
{
	public void addProducts(Products products);
	public List<Products> retriveProducts();
	public Products retriveProducts(int products_Id);
	public void deleteProducts(int products_Id);
}
