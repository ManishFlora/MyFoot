package com.chappal.foot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.CartItemsDAOImplementation;
import com.chappal.foot.model.CartItems;

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
}
