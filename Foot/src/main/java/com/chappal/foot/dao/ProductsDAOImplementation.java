package com.chappal.foot.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.ProductsDAO;
import com.chappal.foot.model.ListProducts;
import com.chappal.foot.model.Products;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;;

@Repository
public class ProductsDAOImplementation implements ProductsDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public void addProducts(Products products) 
	{	
		products.setDiscountedPrice((products.getProductsPrice() * products.getProductsDiscount())/100);
		sessionFactory.getCurrentSession().save(products);
	}
	
	public void updateProducts(Products products) 
	{	
		sessionFactory.getCurrentSession().update(products);
	}
	
	public List<Products> retriveProducts() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Products> productsList = session.createQuery("from Products").getResultList();
		return productsList;
	}

	public Products retriveProducts(String productsId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Products> productsList = session.createQuery("from Products where productsId = '" + productsId + "'").getResultList();
		if(productsList != null && !productsList.isEmpty())
		{
			return productsList.get(0);
		}
		else
		{
			return null;
		}
	}

	public void deleteProducts(String productsId) 
	{
		Products productDelete = new Products();
		productDelete.setProductsId(productsId);
		sessionFactory.getCurrentSession().delete(productDelete);
	}

	public String retriveJsonProducts() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Products> productsList = session.createQuery("from Products").getResultList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(productsList);
		return json;
	}
	
	public int retriveCount() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Products> productList = session.createQuery("from Products").getResultList();
		int count = productList.size();
		return count;
	}
	
	public String generateId()
	{
		String id;
		int count = retriveCount() + 1;
		if(count < 10)
		{
			id = "PR0000" + count;
		}
		else if(count < 100)
		{
			id = "PR000" + count;
		}
		else if(count < 1000)
		{
			id = "PR00" + count;
		}
		else if(count < 10000)
		{
			id = "PR0" + count;
		}
		else
		{
			id = "PR" + count;
		}
		return id;
	}

	public ListProducts retriveListProducts(String productsId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ListProducts> listProducts = session.createQuery("from ListProducts where productsId = '" + productsId + "'").getResultList();
		if(listProducts != null && !listProducts.isEmpty())
		{
			return listProducts.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public int retriveCount(String productsId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Products> productList = session.createQuery("from Products where productsId = '" + productsId + "'").getResultList();
		int count = productList.size();
		return count;
	}

	public String retriveListProducts() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ListProducts> listProducts = session.createQuery("from ListProducts").getResultList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(listProducts);
		return json;
	}
	
	public String retriveLatestListProducts() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ListProducts> listProducts = session.createQuery("from ListProducts order by productsId desc").getResultList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(listProducts);
		return json;
	}
	
}
