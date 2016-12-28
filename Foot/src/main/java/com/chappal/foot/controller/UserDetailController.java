package com.chappal.foot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.service.UserDetailServices;

@Controller
public class UserDetailController 
{
	@Autowired
	UserDetailServices userDetailServices;
	
	@RequestMapping("/registrationform")
	public String registration(Model model)
	{
		UserDetail userDetail = new UserDetail();
		ShippingAddress shippingAddress = new ShippingAddress();
		BillingAddress billingAddress = new BillingAddress();
		userDetail.setBillingAddress(billingAddress);
		userDetail.setShippingAddress(shippingAddress);
		model.addAttribute("userDetail" , userDetail);
		return "/registrationform";
	}
	
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("userDetail") UserDetail userDetail)
	{
		userDetailServices.addUserDetail(userDetail);
		return "redirect:/registrationform";
	}
	@RequestMapping("/loginform")
	public String loginform()
	{
		return "/loginform";
	}
	
//	@RequestMapping("/perform_login")
//	public String performLogin()
//	{
//		return "redirect:/";
//	}
}