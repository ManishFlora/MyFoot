package com.chappal.foot.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chappal.foot.model.CartItems;
import com.chappal.foot.model.ProductSpecification;
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
	public String buyNow(@ModelAttribute("productSpecification") ProductSpecification productSpecification,@PathVariable("productsId") String productsId,WishList wishList,@RequestParam("userId") String userId, HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		userId = userDetailServices.retriveUserByName(userName).getUserId();
		String cartId = userDetailServices.retriveUserByName(userName).getCartId();
		String productsName = productsServices.retriveProducts(productsId).getProductsName();
		int count = wishListServices.retriveListByNameCount(productsName,userId);
		String wishListId = "";
		if(count == 1)
		{
			 wishListId = wishListServices.retriveListByName(productsName,userId).getWishListId();
			 System.out.println(wishListId);
		}
		else
		{
			if(productSpecification.getSize() == null && productSpecification.getMaterial() == null && productSpecification.getColor() == null)
			{
				String color = productsServices.retriveProductSpecification(productsId).getColor();
				String[] colorData = color.split(",");
				String material = productsServices.retriveProductSpecification(productsId).getMaterial();
				String[] materialData = material.split(",");
				String size = productsServices.retriveProductSpecification(productsId).getSize();
				String[] sizeData = size.split(",");
				wishList.setOrderDetail("Color: " + colorData[0] + " , Material: " + materialData[0] + ", Size: " + sizeData[3]);
			}
			else
			{
				wishList.setOrderDetail("Color: " + productSpecification.getColor() + " ,Material: " + productSpecification.getMaterial() + " ,Size: " + productSpecification.getSize());
			}
			wishList.setCartId(cartId);
			wishList.setUserId(userId);
			wishList.setProductsId(productsId);
			wishList.setQuantity(1);
			wishList.setFlag(false);
			wishList.setProductsName(productsName);
			int price = productsServices.retriveProducts(productsId).getProductsPrice();
			int discount = (int)productsServices.retriveProducts(productsId).getDiscountedPrice();
			int amount = price - discount;
			wishList.setAmount(amount);
			wishList.setWishListId(wishListServices.generatedId());
			wishListServices.addWishList(wishList);
			wishListId = wishList.getWishListId();
		}
		session.setAttribute("wishListId", wishListId);
		return "redirect:/wishListItems";
	}
	
	@RequestMapping("/wishListItems")
	public String wishList(String wishListId, HttpSession session, Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		String userId = userDetailServices.retriveUserByName(userName).getUserId();
		String cartId = userDetailServices.retriveUserByName(userName).getCartId();
		session.setAttribute("userId", userId);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		model.addAttribute("wishList", gson.toJson(wishListServices.listOrderProducts(userId,cartId)));
		return "/wishListPage";
	}
	
	@RequestMapping("/deleteWishList-{cartId}")
	public String delete(@PathVariable("cartId") String cartId)
	{
		String wishListId = wishListServices.retriveByCartId(cartId).getWishListId();
		wishListServices.deleteWishList(wishListId);
		return "redirect:/wishListItems";
	}
}
