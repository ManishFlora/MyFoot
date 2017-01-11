package com.chappal.foot.controller;

import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chappal.foot.model.CartItems;
import com.chappal.foot.service.CartItemsServices;
import com.chappal.foot.service.ProductsServices;
import com.chappal.foot.service.UserDetailServices;

@Controller
public class CartItemsController 
{
	@Autowired
	CartItemsServices cartItemsServices;
	@Autowired
	UserDetailServices userDetailServices;
	@Autowired
	ProductsServices productsServices;
	
	@RequestMapping("/buyNow-{productsId}")
	public String buyNow(@PathVariable("productsId") String productsId,CartItems cartItems,@RequestParam("userId") int userId)
	{
		String status;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		if(userDetailServices.retriveUserByName(userName) == null)
		{
			status =  "/login";
		}
		else
		{
			int count = 1;
			if(count == 1)
			{
				cartItems.setCartItemsId(cartItemsServices.generateId());
				userId = userDetailServices.retriveUserByName(userName).getUserId();
				cartItems.setCartId(userId);
				cartItems.setUserId(userId);
				cartItems.setProductsId(productsId);
				cartItems.setQuantity(1);
				cartItems.setFlag(false);
				String productsName = productsServices.retriveProducts(productsId).getProductsName();
				cartItems.setProductName(productsName);
				int amount = productsServices.retriveProducts(productsId).getProductsPrice();
				cartItems.setAmount(amount);
				Date date = new Date();
				cartItems.setOrderDate(date);
				cartItemsServices.addCartItems(cartItems);
				status =  "/orderpage";
			}
			else
			{
				status =  "/orderpage";
			}
		}
		return status;
	}
}
