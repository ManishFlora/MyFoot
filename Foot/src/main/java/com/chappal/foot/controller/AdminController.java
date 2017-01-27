package com.chappal.foot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chappal.foot.service.SupplierServices;
import com.chappal.foot.service.UserDetailServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class AdminController 
{
	@Autowired
	UserDetailServices userDetailServices;
	@Autowired
	SupplierServices supplierServices;
	
	@RequestMapping("/adminPanel")
	public String adminPanel(Model model)
	{
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		model.addAttribute("userList",gson.toJson(userDetailServices.retriveList()));
		model.addAttribute("supplierList",gson.toJson(supplierServices.retriveList()));
		return "/adminPanel";
	}
	
	@RequestMapping("/blockUser-{userId}")
	public String blockUser(@PathVariable("userId") String userId)
	{
		String userName = userDetailServices.retriveUserDeatilsById(userId).getUserName();
		userDetailServices.blockUser(userName);
		return "redirect:/adminPanel";
	}
	
	@RequestMapping("/updateSupplier-{userId}")
	public String updateSupplier(@PathVariable("userId") String userId)
	{
		String supplierId = userDetailServices.retriveUserDeatilsById(userId).getSupplier().getSupplierId();
		supplierServices.updateFlag(supplierId);
		return "redirect:/adminPanel";
	}
}
