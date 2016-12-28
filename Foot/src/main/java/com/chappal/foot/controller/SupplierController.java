package com.chappal.foot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chappal.foot.model.Supplier;
import com.chappal.foot.service.SupplierServices;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierServices supplierServices;
	
	@RequestMapping("/supplierform")
	public String supplier(Model model)
	{
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierJsonList", supplierServices.retriveJsonSupplier());
		return "/supplierform";
	}
	
	@RequestMapping("/addSupplier")
	public String addSupplier(Model model, @Valid @ModelAttribute("supplier") Supplier supplier, BindingResult result)
	{
		if(result.hasErrors())
		{
			model.addAttribute("supplierJsonList", supplierServices.retriveJsonSupplier());
			return "/supplierform";
		}
		else
		{
			supplierServices.addSupplier(supplier);
			return "redirect:/supplierform";
		}
	}
	
	@RequestMapping("/editSupplier-{supplier_Id}")
	public String retriveSupplier(@PathVariable("supplier_Id") int supplier_Id, Model model)
	{
		model.addAttribute("supplier", supplierServices.retriveSupplier(supplier_Id));
		return "/supplierform";
	}
	
	@RequestMapping("/deleteSupplier-{supplier_Id}")
	public String deleteSupplier(@PathVariable("supplier_Id") int supplier_Id)
	{
		supplierServices.deleteSupplier(supplier_Id);
		return "redirect:/supplierform";
	}
}