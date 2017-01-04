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
	
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		return "/index";
	}
	@RequestMapping("/403")
	public String error403()
	{
		return "/403";
	}
	@RequestMapping("/aboutus")
	public String aboutus()
	{
		return "/aboutus";
	}
}
