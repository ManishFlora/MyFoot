package com.chappal.foot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chappal.foot.model.Category;
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;

@Controller
public class FootController 
{
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	BrandServices brandServices;
	
	@RequestMapping(value={"/","/home"})
	public String index(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
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
	
	@RequestMapping("/viewproduct")
	public String viewProduct()
	{
		return "/viewproduct";
	}
}
