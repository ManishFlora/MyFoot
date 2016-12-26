package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.ProductsDAOImplementation;
import com.chappal.foot.model.Products;

@Service
@Transactional
public class ProductsServices 
{
	@Autowired
	ProductsDAOImplementation productsDAOImplementation;
	
	public void addProducts(Products products)
	{
		productsDAOImplementation.addProducts(products);
	}
	public List<Products> retriveProducts()
	{
		return productsDAOImplementation.retriveProducts();
	}
	public Products retriveProducts(int products_Id)
	{
		return productsDAOImplementation.retriveProducts(products_Id);
	}
	public void deleteProducts(int products_Id)
	{
		productsDAOImplementation.deleteProducts(products_Id);
	}
	
	public String retriveJsonProducts() 
	{
		return productsDAOImplementation.retriveJsonProducts();
	}
}
