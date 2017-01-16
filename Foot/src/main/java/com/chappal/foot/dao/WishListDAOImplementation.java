package com.chappal.foot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.WishListDAO;
import com.chappal.foot.model.WishList;

@Repository
public class WishListDAOImplementation implements WishListDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
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
}
