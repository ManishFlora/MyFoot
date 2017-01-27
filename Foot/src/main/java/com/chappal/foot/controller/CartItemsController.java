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
import com.chappal.foot.model.ProductSpecification;
import com.chappal.foot.service.CartItemsServices;
import com.chappal.foot.service.ProductsServices;
import com.chappal.foot.service.ProductsSpecificationServices;
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
	public String buyNow(@PathVariable("productsId") String productsId,@ModelAttribute("cartItems") CartItems cartItems, @ModelAttribute("productSpecification") ProductSpecification productSpecification,@RequestParam("userId") String userId, HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		System.out.println(1);
		userId = userDetailServices.retriveUserByName(userName).getUserId();
		System.out.println(2);
		String cartId = userDetailServices.retriveUserByName(userName).getCartId();
		System.out.println(3);
		if(productSpecification.getSize() == null && productSpecification.getMaterial() == null && productSpecification.getColor() == null)
		{
			System.out.println(4);
			String color = productsServices.retriveProductSpecification(productsId).getColor();
			String[] colorData = color.split(",");
			String material = productsServices.retriveProductSpecification(productsId).getMaterial();
			String[] materialData = material.split(",");
			String size = productsServices.retriveProductSpecification(productsId).getSize();
			String[] sizeData = size.split(",");
			cartItems.setOrderDetail("Color: " + colorData[0] + " , Material: " + materialData[0] + ", Size: " + sizeData[3]);
		}
		else
		{
			cartItems.setOrderDetail("Color: " + productSpecification.getColor() + " ,Material: " + productSpecification.getMaterial() + " ,Size: " + productSpecification.getSize());
		}
		System.out.println(cartItems.getOrderDetail());
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
		cartItems.setCartId(cartId);
		cartItems.setCartItemsId(cartItemsServices.generateId());
		System.out.println(cartId);
		cartItemsServices.addCartItems(cartItems);
		productsServices.updateProductsQuantity(productsId);
		session.setAttribute("cartItemsId", cartItems.getCartItemsId());
		session.setAttribute("productsId", productsId);
		String cartItemsId=(String) session.getAttribute("cartItemsId");
		return "redirect:/cartList-"+cartItemsId;
	}
	
	@RequestMapping("/cartList-{cartItemsId}")
	public String cartList(@PathVariable("cartItemsId") String cartItemsId, HttpSession session, Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		String userId = userDetailServices.retriveUserByName(userName).getUserId();
		session.setAttribute("userId", userId);
		session.setAttribute("cartItemsId", cartItemsId);
		String productsId = cartItemsServices.cartItemsListById(cartItemsId).getProductsId();
		int price = (int) (productsServices.retriveListOrderProducts(productsId).getProductsPrice() - productsServices.retriveListOrderProducts(productsId).getDiscountedPrice());
		session.setAttribute("price", price);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		model.addAttribute("listProducts", gson.toJson(productsServices.retriveListOrderProducts(productsId)));
		model.addAttribute("cartItems", new CartItems());
		return "/orderpage";
	}
	
	@RequestMapping("/checkout")
	public String checkOut(@RequestParam("userId") String userId,HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		userId = userDetailServices.retriveUserByName(userName).getUserId();
		String firstName = userDetailServices.retriveUserByName(userName).getFirstName();
		String lastName = userDetailServices.retriveUserByName(userName).getLastName();
		String cartId = userDetailServices.retriveUserByName(userName).getCartId();
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("userId", userId);
		session.setAttribute("cartId", cartId);
		return "redirect:/cart?userId=" + userId;
	}
	
	@RequestMapping("/addToCart-{productsId}")
	public String addToCart(@ModelAttribute("productSpecification") ProductSpecification productSpecification,@ModelAttribute("cartItems") CartItems cartItems,@PathVariable("productsId") String productsId, HttpSession session,@RequestParam("userId") String userId)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		userId = userDetailServices.retriveUserByName(userName).getUserId();
		String cartId = userDetailServices.retriveUserByName(userName).getCartId();
		String productsName = productsServices.retriveProducts(productsId).getProductsName();
		if(productSpecification.getSize() == null && productSpecification.getMaterial() == null && productSpecification.getColor() == null)
		{
			String color = productsServices.retriveProductSpecification(productsId).getColor();
			String[] colorData = color.split(",");
			String material = productsServices.retriveProductSpecification(productsId).getMaterial();
			String[] materialData = material.split(",");
			String size = productsServices.retriveProductSpecification(productsId).getSize();
			String[] sizeData = size.split(",");
			cartItems.setOrderDetail("Color: " + colorData[0] + " , Material: " + materialData[0] + ", Size: " + sizeData[3]);
		}
		else
		{
			cartItems.setOrderDetail("Color: " + productSpecification.getColor() + " ,Material: " + productSpecification.getMaterial() + " ,Size: " + productSpecification.getSize());
		}
		int count = cartItemsServices.retriveListByNameCount(productsName,userId,cartItems.getOrderDetail());
		String cartItemsId;
		if(count == 1)
		{
			int quantity = 0;
			cartItemsId = cartItemsServices.retriveListByName(productsName,userId).getCartItemsId();
			if(cartItems.getQuantity() == 0)
			{
				quantity = 1;
			}
			else
			{
				quantity = cartItems.getQuantity();
			}
			cartItemsServices.updateQuantity(cartItemsId, quantity);
		}
		else
		{
			if(cartItems.getQuantity() == 0)
			{
				cartItems.setQuantity(1);
			}
			cartItems.setUserId(userId);
			cartItems.setProductsId(productsId);
			cartItems.setFlag(false);
			System.out.println(cartItems.getOrderDetail());
			cartItems.setProductName(productsName);
			int price = productsServices.retriveProducts(productsId).getProductsPrice();
			int discount = (int)productsServices.retriveProducts(productsId).getDiscountedPrice();
			int amount = price - discount;
			cartItems.setAmount(amount);
			Date date = new Date();
			cartItems.setOrderDate(date);
			cartItems.setCartId(cartId);
			cartItems.setCartItemsId(cartItemsServices.generateId());
			session.setAttribute("productsId", productsId);
			cartItemsServices.addCartItems(cartItems);
			productsServices.updateProductsQuantity(productsId,cartItems.getQuantity());
			cartItemsId = cartItems.getCartItemsId();
		}
		session.setAttribute("cartItemsId", cartItemsId);
		return "redirect:cartItems";
	}
	
	@RequestMapping("/cartItems")
	public String cartItems(String cartItemsId, HttpSession session, Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		String userId = userDetailServices.retriveUserByName(userName).getUserId();
		String cartId = userDetailServices.retriveUserByName(userName).getCartId();
		session.setAttribute("userId", userId);		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		model.addAttribute("cartList", gson.toJson(cartItemsServices.listOrderProducts(userId,cartId)));
		model.addAttribute("cartItems", new CartItems());
		return "/orderpage-2";
	}
	
	@RequestMapping("/checkoutCart")
	public String checkOutCart(@RequestParam("userId") String userId,HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		userId = userDetailServices.retriveUserByName(userName).getUserId();
		String firstName = userDetailServices.retriveUserByName(userName).getFirstName();
		String lastName = userDetailServices.retriveUserByName(userName).getLastName();
		String cartId = userDetailServices.retriveUserByName(userName).getCartId();
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("userId", userId);
		session.setAttribute("cartId", cartId);
		return "redirect:/cartProcess?userId=" + userId;
	}
	
	
	@RequestMapping("/deleteCartItems-{cartId}")
	public String delete(@PathVariable("cartId") String cartId)
	{
		String cartItemsId = cartItemsServices.retriveByCartId(cartId).getCartItemsId();
		cartItemsServices.cartItemsDelete(cartItemsId);
		return "redirect:/cartItems";
	}
}
