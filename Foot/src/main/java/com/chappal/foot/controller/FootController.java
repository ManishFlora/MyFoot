package com.chappal.foot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.Category;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;
import com.chappal.foot.service.ProductsServices;
import com.chappal.foot.service.UserDetailServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class FootController 
{
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	BrandServices brandServices;
	@Autowired
	ProductsServices productsServices;
	@Autowired
	UserDetailServices userDetailServices;
	
	@RequestMapping(value={"/","/home"})
	public String index(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		model.addAttribute("productList",productsServices.retriveProducts());
		return "/index";
	}
	@RequestMapping("/403")
	public String error403(Model model)
	{
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		return "/403";
	}
	@RequestMapping("/aboutus")
	public String aboutus(Model model)
	{
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		return "/aboutus";
	}
	@RequestMapping("/contact")
	public String contact(Model model)
	{
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		return "/contact";
	}
	@RequestMapping("/profile")
	public String profile(Model model,String userName,@ModelAttribute("userDetail") UserDetail userDetail)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		userName = authentication.getName();
		UserDetail newUserDetail = userDetailServices.retriveUserByName(userName);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String userJson = gson.toJson(newUserDetail);
		model.addAttribute("userList",userJson);
		BillingAddress billingAddress = userDetailServices.retriveBAddressById(newUserDetail.getUserId());
		String billingJson = gson.toJson(billingAddress);
		model.addAttribute("billingAddressList", billingJson);
		ShippingAddress shippingAddress = userDetailServices.retriveSAddressById(newUserDetail.getUserId());
		String shippingJson = gson.toJson(shippingAddress);
		model.addAttribute("shippingAddressList", shippingJson);
		return "/personalinfo";
	}
}
