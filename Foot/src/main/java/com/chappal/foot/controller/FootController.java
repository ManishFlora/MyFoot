package com.chappal.foot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chappal.foot.model.Category;
import com.chappal.foot.model.ListProducts;
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;
import com.chappal.foot.service.ProductsServices;
import com.chappal.foot.service.SubCategoryServices;

@Controller
public class FootController 
{
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	BrandServices brandServices;
	@Autowired
	ProductsServices productsServices;
	@Autowired
	SubCategoryServices subCategoryServices;
	
	@RequestMapping(value={"/","/home"})
	public String index(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		model.addAttribute("productList",productsServices.retriveProducts());
		model.addAttribute("listProducts",productsServices.retriveListProducts());
		model.addAttribute("listLatest", productsServices.retriveLatestListProducts());
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
		return "/aboutus";
	}
	@RequestMapping("/contact")
	public String contact(Model model)
	{
		return "/contact";
	}
	@RequestMapping("/allproducts")
	public String allproducts(Model model,@ModelAttribute("listProducts") ListProducts listProducts)
	{
		model.addAttribute("listProducts", productsServices.retriveListProducts());
		model.addAttribute("subCategoryList",subCategoryServices.retriveJsonSubCategory());
		return "/allproducts";
	}
	
	@RequestMapping("/secure-payment")
	public String secure()
	{
		return "/secure";
	}
	
	@RequestMapping("/delivery")
	public String delivery()
	{
		return "/delivery";
	}
}
