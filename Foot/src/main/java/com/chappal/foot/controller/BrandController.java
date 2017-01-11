package com.chappal.foot.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.chappal.foot.model.Brand;
import com.chappal.foot.model.Category;
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;

@Controller
public class BrandController 
{
	@Autowired
	BrandServices brandServices;
	
	@Autowired
	private CategoryServices categoryServices;
	
	@RequestMapping("/brandform")
	public String brand(Model model)
	{
		model.addAttribute("brand", new Brand());
		model.addAttribute("category", new Category());
		model.addAttribute("brandJsonList", brandServices.retriveJsonBrand());
		model.addAttribute("brandList", brandServices.retriveBrand());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		return "/brandform";
	}
	
	@RequestMapping("/addBrand")
	public String addBrand(Model model,@Valid @ModelAttribute("brand") Brand brand , BindingResult result, String brandId)
	{
		if(result.hasErrors())
		{
			model.addAttribute("brandJsonList", brandServices.retriveJsonBrand());
			return "/brandform";
		}
		else
		{
			brandId = brand.getBrandId();
			int count = brandServices.retriveCount(brandId);
			if(count == 1)
			{
				brandServices.updateBrand(brand);
			}
			else
			{
				brand.setBrandId(brandServices.generateId());
				brandServices.addBrand(brand);
			}
			String path = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\brand\\";
			path = path + String.valueOf(brand.getBrandId()) + ".jpg";
			File file = new File(path);
			MultipartFile multipartFile = brand.getBrandImage();
			if(!multipartFile.isEmpty())
			{
				try 
				{
					byte[] bytes;
					bytes = multipartFile.getBytes();
					FileOutputStream fos = new FileOutputStream(file);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					bos.write(bytes);
					bos.close();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Sorry You are Dumped.");
			}
			return "redirect:/brandform";
		}
	}
	
	@RequestMapping("/editBrand-{brandId}")
	public String retriveBrand(@PathVariable("brandId") String brandId, Model model)
	{
		model.addAttribute("brand", brandServices.retriveBrand(brandId));
		return "/brandform";
	}
	
	@RequestMapping("/deleteBrand-{brandId}")
	public String deletebrand(@PathVariable("brandId") String brandId)
	{
		brandServices.deleteBrand(brandId);
		return "redirect:/brandform";
	}
}
