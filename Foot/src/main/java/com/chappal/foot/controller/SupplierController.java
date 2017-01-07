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
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.SupplierServices;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierServices supplierServices;
	@Autowired
	BrandServices brandServices;
	
	@RequestMapping("/supplierform")
	public String supplier(Model model)
	{
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierJsonList", supplierServices.retriveJsonSupplier());
		model.addAttribute("brandList", brandServices.retriveBrand());
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
			supplier.setSupplierId(supplierServices.generateId());
			supplierServices.addSupplier(supplier);
			return "redirect:/supplierform";
		}
	}
	
	@RequestMapping("/editSupplier-{supplierId}")
	public String retriveSupplier(@PathVariable("supplierId") String supplierId, Model model)
	{
		model.addAttribute("supplier", supplierServices.retriveSupplier(supplierId));
		return "/supplierform";
	}
	
	@RequestMapping("/deleteSupplier-{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") String supplierId)
	{
		supplierServices.deleteSupplier(supplierId);
		return "redirect:/supplierform";
	}
}