package com.chappal.foot.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	public String buyNow(@PathVariable("productsId") String productsId,CartItems cartItems,@RequestParam("userId") int userId, HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		userId = userDetailServices.retriveUserByName(userName).getUserId();
		cartItems.setCartId(userId);
		cartItems.setUserId(userId);
		cartItems.setProductsId(productsId);
		cartItems.setQuantity(1);
		cartItems.setFlag(false);
		String productsName = productsServices.retriveProducts(productsId).getProductsName();
		cartItems.setProductName(productsName);
		int price = productsServices.retriveProducts(productsId).getProductsPrice();
		int discount = (int)productsServices.retriveProducts(productsId).getDiscountedPrice();
		int amount = price - discount;
		cartItems.setAmount(amount);
		Date date = new Date();
		cartItems.setOrderDate(date);
		cartItems.setCartItemsId(cartItemsServices.generateId());
		cartItemsServices.addCartItems(cartItems);
		productsServices.updateProductsQuantity(productsId);
		session.setAttribute("cartItemsId", cartItems.getCartItemsId());
		String cartItemsId=(String) session.getAttribute("cartItemsId");
		return "redirect:/cartList-"+cartItemsId;
	}
	
	@RequestMapping("/cartList-{cartItemsId}")
	public String cartList(@PathVariable("cartItemsId") String cartItemsId, HttpSession session, Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		int userId = userDetailServices.retriveUserByName(userName).getUserId();
		session.setAttribute("userId", userId);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String cartItemsList = gson.toJson(cartItemsServices.cartItemsList(userId));
		model.addAttribute("cartItemsList", cartItemsList);
		return "/orderpage";
	}
	
	@RequestMapping("/checkout")
	public String checkOut(@RequestParam("userId") int userId,HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		userId = userDetailServices.retriveUserByName(userName).getUserId();
		String firstName = userDetailServices.retriveUserByName(userName).getFirstName();
		String lastName = userDetailServices.retriveUserByName(userName).getLastName();
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("userId", userId);
		return "redirect:/cart?userId=" + userId;
	}
}
