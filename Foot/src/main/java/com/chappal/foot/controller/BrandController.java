package com.chappal.foot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chappal.foot.model.Brand;
import com.chappal.foot.service.BrandServices;

@Controller
public class BrandController 
{
	@Autowired
	BrandServices brandServices;
	
	@RequestMapping("/brandform")
	public String brand(Model model)
	{
		model.addAttribute("brand", new Brand());
		model.addAttribute("brandJsonList", brandServices.retriveJsonBrand());
		return "/brandform";
	}
	
	@RequestMapping("/addBrand")
	public String addBrand(Model model,@Valid @ModelAttribute("brand") Brand brand , BindingResult result)
	{
		if(result.hasErrors())
		{
			model.addAttribute("brandJsonList", brandServices.retriveJsonBrand());
			return "/brandform";
		}
		else
		{
			brandServices.addBrand(brand);
			return "redirect:/brandform";
		}
	}
	
	@RequestMapping("/editBrand-{brandId}")
	public String retriveBrand(@PathVariable("brandId") int brandId, Model model)
	{
		model.addAttribute("brand", brandServices.retriveBrand(brandId));
		return "/brandform";
	}
	
	@RequestMapping("/deleteBrand-{brandId}")
	public String deletebrand(@PathVariable("brandId") int brandId)
	{
		brandServices.deleteBrand(brandId);
		return "redirect:/brandform";
	}
}
