package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.ProductsDAOImplementation;
import com.chappal.foot.model.ListOrderProducts;
import com.chappal.foot.model.ListProducts;
import com.chappal.foot.model.ProductSpecification;
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
	public void updateProducts(Products products)
	{
		productsDAOImplementation.updateProducts(products);
	}
	public List<Products> retriveProducts()
	{
		return productsDAOImplementation.retriveProducts();
	}
	public Products retriveProducts(String productsId)
	{
		return productsDAOImplementation.retriveProducts(productsId);
	}
	public void deleteProducts(String productsId)
	{
		productsDAOImplementation.deleteProducts(productsId);
	}
	
	public String retriveJsonProducts() 
	{
		return productsDAOImplementation.retriveJsonProducts();
	}
	
	public String retriveJsonProducts(String productsId) 
	{
		return productsDAOImplementation.retriveJsonProducts(productsId);
	}
	
	public String generateId()
	{
		return productsDAOImplementation.generateId();
	}
	public ListProducts retriveListProducts(String productsId)
	{
		return productsDAOImplementation.retriveListProducts(productsId);
	}
	public int retriveCount(String productsId)
	{
		return productsDAOImplementation.retriveCount(productsId);
	}
	public String retriveListProducts()
	{
		return productsDAOImplementation.retriveListProducts();
	}
	public String retriveLatestListProducts()
	{
		return productsDAOImplementation.retriveLatestListProducts();
	}
	public void updateProductsQuantity(String productsId)
	{
		productsDAOImplementation.updateProductsQuantity(productsId);
	}
	public void updateProductsQuantity(String productsId,int productsQuantity)
	{
		productsDAOImplementation.updateProductsQuantity(productsId,productsQuantity);
	}
	public List<ListProducts> retriveList()
	{
		return productsDAOImplementation.retriveList();
	}
	public ListOrderProducts retriveOrderList(String productsId)
	{
		return productsDAOImplementation.retriveOrderList(productsId);
	}
	public ListOrderProducts retriveListOrderProducts(String productsId)
	{
		return productsDAOImplementation.retriveListOrderProducts(productsId);
	}
	public ProductSpecification retriveProductSpecification(String productsId) 
	{
		return productsDAOImplementation.retriveProductSpecification(productsId);
	}
}
