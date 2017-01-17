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
	
	public List<ListOrderProducts> listOrderProducts(String userId)
	{
		return cartItemsDAOImplementation.listOrderProducts(userId);
	}
}
