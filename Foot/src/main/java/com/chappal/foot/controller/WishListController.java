package com.chappal.foot.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chappal.foot.model.CartItems;
import com.chappal.foot.model.WishList;
import com.chappal.foot.service.ProductsServices;
import com.chappal.foot.service.UserDetailServices;
import com.chappal.foot.service.WishListServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class WishListController 
{
	@Autowired
	UserDetailServices userDetailServices;
	@Autowired
	ProductsServices productsServices;
	@Autowired
	WishListServices wishListServices;
	
	@RequestMapping("/wishList-{productsId}")
	public String buyNow(@PathVariable("productsId") String productsId,WishList wishList,@RequestParam("userId") String userId, HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		userId = userDetailServices.retriveUserByName(userName).getUserId();
		String cartId = userDetailServices.retriveUserByName(userName).getCartId();
		wishList.setCartId(cartId);
		wishList.setUserId(userId);
		wishList.setProductsId(productsId);
		wishList.setQuantity(1);
		wishList.setFlag(false);
		String productsName = productsServices.retriveProducts(productsId).getProductsName();
		wishList.setProductsName(productsName);
		int price = productsServices.retriveProducts(productsId).getProductsPrice();
		int discount = (int)productsServices.retriveProducts(productsId).getDiscountedPrice();
		int amount = price - discount;
		wishList.setAmount(amount);
		wishList.setWishListId(wishListServices.generatedId());
		wishListServices.addWishList(wishList);
		session.setAttribute("wishListId", wishList.getWishListId());
		String wishListId=(String) session.getAttribute("wishListId");
		return "redirect:/wishListItems-"+wishListId;
	}
	
	@RequestMapping("/wishListItems-{wishListId}")
	public String wishList(@PathVariable("wishListId") String wishListId, HttpSession session, Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		String userId = userDetailServices.retriveUserByName(userName).getUserId();
		session.setAttribute("userId", userId);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String wishList = gson.toJson(wishListServices.retriveList(userId));
		model.addAttribute("wishList", wishList);
		return "/wishListPage";
	}
}
