package com.chappal.foot.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.ProductsDAO;
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
		sessionFactory.getCurrentSession().saveOrUpdate(products);
	}

	public List<Products> retriveProducts() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Products> productsList = session.createQuery("from Products").getResultList();
		return productsList;
	}

	public Products retriveProducts(int productsId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Products> productsList = session.createQuery("from Products where productsId = " + productsId).getResultList();
		return productsList.get(0);
	}

	public void deleteProducts(int productsId) 
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
}
