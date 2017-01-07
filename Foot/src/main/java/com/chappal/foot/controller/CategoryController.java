package com.chappal.foot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chappal.foot.model.Category;
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;

@Controller
public class CategoryController 
{
	@Autowired
	private CategoryServices categoryServices;
	@Autowired
	private BrandServices brandServices;
	
	@RequestMapping("/categoryform")
	public String category(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("categoryJsonList", categoryServices.retriveJsonCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		return "/categoryform";
	}
	
	@RequestMapping("/addCategory")
	public String addCategory(Model model,@Valid @ModelAttribute("category") Category category , BindingResult result)
	{
		if(result.hasErrors())
		{
			model.addAttribute("categoryJsonList", this.categoryServices.retriveJsonCategory());
			return "/categoryform";
		}
		else
		{
			category.setCategoryId(categoryServices.generateId());
			categoryServices.addCategory(category);
			return "redirect:/categoryform";
		}
	}
	
	@RequestMapping("/editCategory-{categoryId}")
	public String retriveCategory(Model model, @PathVariable("categoryId") String categoryId)
	{
		model.addAttribute("category", this.categoryServices.retriveCategory(categoryId));
		return "/categoryform";
	}
	
	@RequestMapping("/deleteCategory-{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") String categoryId)
	{
		categoryServices.deleteCategory(categoryId);
		return "redirect:/categoryform";
	}
}