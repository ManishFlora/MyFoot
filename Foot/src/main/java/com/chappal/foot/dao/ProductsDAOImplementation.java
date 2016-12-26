package com.chappal.foot.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.ProductsDAO;
import com.chappal.foot.model.Products;
import com.google.gson.Gson;;

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

	public Products retriveProducts(int products_Id) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Products> productsList = session.createQuery("from Products where products_Id = " + products_Id).getResultList();
		return productsList.get(0);
	}

	public void deleteProducts(int products_Id) 
	{
		Products productDelete = new Products();
		productDelete.setProducts_Id(products_Id);
		sessionFactory.getCurrentSession().delete(productDelete);
	}

	public String retriveJsonProducts() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Products> productsList = session.createQuery("from Products").getResultList();
		Gson gson = new Gson();
		String json = gson.toJson(productsList);
		return json;
	}
}
