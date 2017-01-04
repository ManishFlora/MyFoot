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
import com.chappal.foot.model.SubCategory;
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;
import com.chappal.foot.service.SubCategoryServices;

@Controller
public class SubCategoryController 
{
	@Autowired
	private CategoryServices categoryServices;
	@Autowired
	SubCategoryServices subCategoryServices;
	@Autowired
	BrandServices brandServices;
	
	@RequestMapping("/subcategoryform")
	public String subCategory(Model model)
	{
		model.addAttribute("subCategory", new SubCategory());
		model.addAttribute("category", new Category());
		model.addAttribute("subCategoryJsonList", subCategoryServices.retriveJsonSubCategory());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		return "/subcategoryform";
	}
	
	@RequestMapping("/addsubcategory")
	public String addSubCategory(Model model, @Valid @ModelAttribute("subCategory") SubCategory subCategory, BindingResult result)
	{
		if(result.hasErrors())
		{
			model.addAttribute("subCategoryJsonList", subCategoryServices.retriveJsonSubCategory());
			model.addAttribute("categoryList", categoryServices.retriveCategory());
			return "/subcategoryform";
		}
		else
		{
			Category category = categoryServices.retriveCategoryName(subCategory.getCategory().getCategoryName());
			subCategory.setCategory(category);
			subCategory.setCategoryId(category.getCategoryId());
			subCategoryServices.addSubCategory(subCategory);
			return "redirect:/subcategoryform";
		}
	}
	
	@RequestMapping("/editSubCategory-{subCategoryId}")
	public String retriveCategory(@PathVariable("subCategoryId") int subCategoryId, Model model)
	{
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("subCategory", subCategoryServices.retriveSubCategory(subCategoryId));
		return "/subcategoryform";
	}
	
	@RequestMapping("/deleteSubCategory-{subCategoryId}")
	public String deleteCategory(@PathVariable("subCategoryId") int subCategoryId)
	{
		subCategoryServices.deleteSubCategory(subCategoryId);
		return "redirect:/subcategoryform";
	}
}
