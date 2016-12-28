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
import com.chappal.foot.model.Products;
import com.chappal.foot.model.SubCategory;
import com.chappal.foot.model.Supplier;
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;
import com.chappal.foot.service.ProductsServices;
import com.chappal.foot.service.SubCategoryServices;
import com.chappal.foot.service.SupplierServices;

@Controller
public class ProductsController 
{
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	SubCategoryServices subCategoryServices;
	@Autowired
	SupplierServices supplierServices;
	@Autowired
	BrandServices brandServices;
	@Autowired
	ProductsServices productsServices;
	
	@RequestMapping("/productsform")
	public String products(Model model)
	{
		model.addAttribute("products", new Products());
		model.addAttribute("subcategory", new SubCategory());
		model.addAttribute("category", new Category());
		model.addAttribute("brand", new Brand());
		model.addAttribute("supplier", new Supplier());
		
		model.addAttribute("subCategoryList", subCategoryServices.retriveSubCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		model.addAttribute("supplierList", supplierServices.retriveSupplier());
		model.addAttribute("productsJsonList", productsServices.retriveJsonProducts());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		return "/productsform";
	}
	@RequestMapping("/addproducts")
	public String addProducts(Model model,@Valid @ModelAttribute("products") Products products,BindingResult result)
	{
		if(result.hasErrors())
		{
			model.addAttribute("subCategoryList", subCategoryServices.retriveSubCategory());
			model.addAttribute("brandList", brandServices.retriveBrand());
			model.addAttribute("supplierList", supplierServices.retriveSupplier());
			model.addAttribute("productsJsonList", productsServices.retriveJsonProducts());
			model.addAttribute("categoryList", categoryServices.retriveCategory());
			return "/productsform";
		}
		else
		{
			Category category = categoryServices.retriveCategoryName(products.getCategory().getCategory_Name());
			Supplier supplier = supplierServices.retriveSupplierName(products.getSupplier().getSupplier_Name());
			SubCategory subcategory = subCategoryServices.retriveSubCategoryName(products.getSubcategory().getSubcategory_Name());
			Brand brand = brandServices.retriveBrandName(products.getBrand().getBrand_Name());
		
			products.setCategory(category);
			products.setBrand(brand);
			products.setSubcategory(subcategory);
			products.setSupplier(supplier);
			
			products.setCategory_Id(category.getCategory_Id());
			products.setBrand_Id(brand.getBrand_Id());
			products.setSubcategory_Id(subcategory.getSubcategory_Id());
			products.setSupplier_Id(supplier.getSupplier_Id());
			
			productsServices.addProducts(products);
		
			String path = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\";
			path = path + String.valueOf(products.getProducts_Id()) + ".jpg";
			File file = new File(path);
			MultipartFile multipartFile = products.getProducts_Image();
			
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
			return "redirect:/productsform";
		}
	}
	
	@RequestMapping("/editProducts-{products_Id}")
	public String retriveProducts(@PathVariable("products_Id") int products_Id, Model model)
	{
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("subCategoryList", subCategoryServices.retriveSubCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		model.addAttribute("supplierList", supplierServices.retriveSupplier());
		model.addAttribute("products", productsServices.retriveProducts(products_Id));
		return "/productsform";
	}
	
	@RequestMapping("/deleteProducts-{products_Id}")
	public String deleteCategory(@PathVariable("products_Id") int products_Id)
	{
		productsServices.deleteProducts(products_Id);
		return "redirect:/productsform";
	}
}