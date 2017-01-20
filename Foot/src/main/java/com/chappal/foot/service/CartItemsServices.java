package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.CartItemsDAOImplementation;
import com.chappal.foot.model.CartItems;
import com.chappal.foot.model.ListOrderProducts;
import com.chappal.foot.model.ListProducts;

@Transactional
@Service
public class CartItemsServices 
{
	@Autowired
	CartItemsDAOImplementation cartItemsDAOImplementation;
	
	public void addCartItems(CartItems cartItems)
	{
		cartItemsDAOImplementation.addCartItems(cartItems);
	}
	
	public String generateId()
	{
		return cartItemsDAOImplementation.generateId();
	}
	
	public List<CartItems> cartItemsList(String userId)
	{
		return cartItemsDAOImplementation.cartItemsList(userId);
	}
	
	public CartItems cartItemsListById(String cartItemsId)
	{
		return cartItemsDAOImplementation.cartItemsListById(cartItemsId);
	}
	
	public List<ListOrderProducts> listOrderProducts(String userId,String cartId)
	{
		return cartItemsDAOImplementation.listOrderProducts(userId,cartId);
	}
	
	public void updateFlag(String cartItemsId)
	{
		cartItemsDAOImplementation.updateFlag(cartItemsId);
	}
	
	public void updateAllFlag(String cartId)
	{
		cartItemsDAOImplementation.updateAllFlag(cartId);
	}
	public int retriveListByNameCount(String productsName,String userId,String orderDetail)
	{
		return cartItemsDAOImplementation.retriveListByNameCount(productsName,userId,orderDetail);
	}
	public CartItems retriveListByName(String productsName,String userId)
	{
		return cartItemsDAOImplementation.retriveListByName(productsName,userId);
	}
	public void updateQuantity(String cartItemsId,int quantity)
	{
		cartItemsDAOImplementation.updateQuantity(cartItemsId, quantity);
	}
	public void cartItemsDelete(String cartItemsId)
	{
		cartItemsDAOImplementation.cartItemsDelete(cartItemsId);
	}
	public CartItems retriveByCartId(String cartId)
	{
		return cartItemsDAOImplementation.retriveByCartId(cartId);
	}
}
