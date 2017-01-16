package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.WishListDAOImplementation;
import com.chappal.foot.model.WishList;

@Transactional
@Service
public class WishListServices 
{
	@Autowired
	WishListDAOImplementation wishListDAOImplementation;
	
	public void addWishList(WishList wishList)
	{
		wishListDAOImplementation.addWishList(wishList);
	}
	public String generatedId()
	{
		return wishListDAOImplementation.generatedId();	
	}
	public List<WishList> retriveList(String userId)
	{
		return wishListDAOImplementation.retriveList(userId);
	}
}
