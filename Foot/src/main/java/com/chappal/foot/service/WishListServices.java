package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.WishListDAOImplementation;
import com.chappal.foot.model.ListOrderProducts;
import com.chappal.foot.model.WishList;
import com.chappal.foot.model.WishListProducts;

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
	public List<WishListProducts> listOrderProducts(String userId,String wishListId)
	{
		return wishListDAOImplementation.listOrderProducts(userId, wishListId);
	}
	public WishList retriveListById(String wishListId)
	{
		return wishListDAOImplementation.retriveListById(wishListId);
	}
	public WishList retriveListByName(String productsName,String userId)
	{
		return wishListDAOImplementation.retriveListByName(productsName,userId);
	}
	public int retriveListByNameCount(String productsName,String userId)
	{
		return wishListDAOImplementation.retriveListByNameCount(productsName,userId);
	}
	
	public void deleteWishList(String wishListId)
	{
		wishListDAOImplementation.deleteWishList(wishListId);
	}
	
	public WishList retriveByCartId(String cartId)
	{
		return wishListDAOImplementation.retriveByCartId(cartId);
	}
}
