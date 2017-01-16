package com.chappal.foot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;

@ControllerAdvice("com.chappal.foot")
public class DynamicController 
{
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	BrandServices brandServices;
	
	@ModelAttribute
	public void data(Model model)
	{
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
	}
}
