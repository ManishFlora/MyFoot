package com.chappal.foot.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.CartItemsDAO;
import com.chappal.foot.model.CartItems;
import com.chappal.foot.model.ListProducts;
import com.chappal.foot.service.ProductsServices;

@Repository
public class CartItemsDAOImplementation implements CartItemsDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductsServices productsServices;
	
	public void addCartItems(CartItems cartItems) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(cartItems);
		session.flush();
	}
	public int retriveCount() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CartItems> cartList = session.createQuery("from CartItems").getResultList();
		int count = cartList.size();
		return count;
	}
	
	public String generateId()
	{
		String id;
		int count = retriveCount() + 1;
		if(count < 10)
		{
			id = "C0000" + count;
		}
		else if(count < 100)
		{
			id = "C000" + count;
		}
		else if(count < 1000)
		{
			id = "C00" + count;
		}
		else if(count < 10000)
		{
			id = "C0" + count;
		}
		else
		{
			id = "C" + count;
		}
		return id;
	}
	
	public CartItems cartItemsListById(String cartItemsId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CartItems> cartList = session.createQuery("from CartItems where cartItemsId = '" + cartItemsId + "'").getResultList();
		return cartList.get(0);
	}
	
	public List<CartItems> cartItemsList(String userId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CartItems> cartList = session.createQuery("from CartItems where userId = '" + userId + "' and flag=false").getResultList();
		return cartList;
	}
	
	public List<ListProducts> listProducts(String userId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<CartItems> cartList = session.createQuery("from CartItems where userId = '" + userId + "' and flag=false").getResultList();
		List<ListProducts> listProducts = new ArrayList<ListProducts>();
		int count = cartList.size();
		for(int i = 0;i < count;i++)
		{
			String productsId = cartList.get(i).getProductsId();
			listProducts.add(productsServices.retriveListProducts(productsId));
		}
		return listProducts;
	}
	
}
