package com.chappal.foot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;
import com.chappal.foot.service.SupplierServices;
import com.chappal.foot.service.UserDetailServices;

@ControllerAdvice("com.chappal.foot")
public class DynamicController 
{
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	BrandServices brandServices;
	@Autowired
	SupplierServices supplierServices;
	@Autowired
	UserDetailServices userDetailServices;
	
	@ModelAttribute
	public void data(Model model)
	{
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		if(userName != "anonymousUser")
		{
			String userId = userDetailServices.retriveUserByName(userName).getUserId();
			boolean flag = supplierServices.retriveSupplierByUserId(userId).isFlag();
			model.addAttribute("flag", flag);
		}
	}
}
