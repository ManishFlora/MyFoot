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
import com.chappal.foot.service.CategoryServices;
import com.chappal.foot.service.SubCategoryServices;

@Controller
public class SubCategoryController 
{
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	SubCategoryServices subCategoryServices;
	
	@RequestMapping("/subcategoryform")
	public String subCategory(Model model)
	{
		model.addAttribute("subCategory", new SubCategory());
		model.addAttribute("category", new Category());
		model.addAttribute("subCategoryJsonList", subCategoryServices.retriveJsonSubCategory());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
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
			Category category = categoryServices.retriveCategoryName(subCategory.getCategory().getCategory_Name());
			subCategory.setCategory(category);
			subCategory.setCategory_Id(category.getCategory_Id());
			subCategoryServices.addSubCategory(subCategory);
			return "redirect:/subcategoryform";
		}
	}
	
	@RequestMapping("/editSubCategory-{subcategory_Id}")
	public String retriveCategory(@PathVariable("subcategory_Id") int subcategory_Id, Model model)
	{
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("subCategory", subCategoryServices.retriveSubCategory(subcategory_Id));
		return "/subcategoryform";
	}
	
	@RequestMapping("/deleteSubCategory-{subcategory_Id}")
	public String deleteCategory(@PathVariable("subcategory_Id") int subcategory_Id)
	{
		subCategoryServices.deleteSubCategory(subcategory_Id);
		return "redirect:/subcategoryform";
	}
}
