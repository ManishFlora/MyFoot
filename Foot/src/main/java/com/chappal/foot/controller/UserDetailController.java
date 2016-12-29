package com.chappal.foot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null)
		{
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/";
	}
}