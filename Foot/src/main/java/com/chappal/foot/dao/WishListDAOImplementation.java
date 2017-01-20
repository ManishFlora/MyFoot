package com.chappal.foot.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.WishListDAO;
import com.chappal.foot.model.CartItems;
import com.chappal.foot.model.ListOrderProducts;
import com.chappal.foot.model.WishList;
import com.chappal.foot.model.WishListProducts;
import com.chappal.foot.service.ProductsServices;

@Repository
public class WishListDAOImplementation implements WishListDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductsServices productsServices;
	
	public void addWishList(WishList wishList) 
	{
		sessionFactory.getCurrentSession().save(wishList);
	}
	
	public int retriveCount()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<WishList> wishList = session.createQuery("from WishList").getResultList();
		int count = wishList.size();
		return count;
	}
	
	public String generatedId()
	{
		String id;
		int count = retriveCount() + 1;
		if(count < 10)
		{
			id = "WL0000" + count;
		}
		else if(count < 100)
		{
			id = "WL000" + count;
		}
		else if(count < 1000)
		{
			id = "WL00" + count;
		}
		else if(count < 10000)
		{
			id = "WL0" + count;
		}
		else
		{
			id = "WL" + count;
		}
		return id;
	}
	
	public List<WishList> retriveList(String userId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<WishList> wishList = session.createQuery("from WishList where userId = '" + userId + "'").getResultList();
		return wishList;
	}
	
	public WishList retriveListById(String wishListId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<WishList> wishList = session.createQuery("from WishList where wishListId = '" + wishListId + "'").getResultList();
		if(wishList.isEmpty())
		{
			return null;
		}
		else
		{	
			return wishList.get(0);
		}
	}
	
	public WishList retriveListByName(String productsName,String userId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<WishList> wishList = session.createQuery("from WishList where productsName = '" + productsName + "' and userId = '" + userId + "'").getResultList();
		if(wishList.isEmpty() && wishList.size() == 0)
		{
			return null;
		}
		else
		{
			return wishList.get(0);
		}
	}
	
	public int retriveListByNameCount(String productsName,String userId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<WishList> wishList = session.createQuery("from WishList where productsName = '" + productsName + "' and userId = '" + userId + "'").getResultList();
		return wishList.size();
	}
	
	public List<WishListProducts> listOrderProducts(String userId,String wishListId)
	{
		if(wishListId == null)
		{
			return null;
		}
		else
		{		
			Session session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<WishList> wishList= session.createQuery("from WishList where userId = '" + userId + "' and flag=false").getResultList();
			List<WishListProducts> listOrderProducts = new ArrayList<WishListProducts>();
			int count = wishList.size();
			for(int i = 0;i < count;i++)
			{
				String productsId = wishList.get(i).getProductsId();
				listOrderProducts.add(productsServices.retriveWishOrderList(productsId,wishListId));
			}
			return listOrderProducts;
		}
	}
	
	public void deleteWishList(String wishListId)
	{
		WishList wishListDelete = new WishList();
		wishListDelete.setWishListId(wishListId);
		sessionFactory.getCurrentSession().delete(wishListDelete);
	}
	
	public WishList retriveByCartId(String cartId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<WishList> wishList = session.createQuery("from WishList where cartId = '" + cartId + "'").getResultList();
		return wishList.get(0);
	}
}
