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
import com.chappal.foot.model.ProductSpecification;
import com.chappal.foot.model.Products;
import com.chappal.foot.model.SubCategory;
import com.chappal.foot.model.Supplier;
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;
import com.chappal.foot.service.ProductsServices;
import com.chappal.foot.service.ProductsSpecificationServices;
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
	@Autowired
	ProductsSpecificationServices productsSpecificationServices;
	
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
			Category category = categoryServices.retriveCategoryName(products.getCategory().getCategoryName());
			Supplier supplier = supplierServices.retriveSupplierName(products.getSupplier().getSupplierName());
			SubCategory subcategory = subCategoryServices.retriveSubCategoryName(products.getSubcategory().getSubCategoryName());
			Brand brand = brandServices.retriveBrandName(products.getBrand().getBrandName());
		
			products.setCategory(category);
			products.setBrand(brand);
			products.setSubcategory(subcategory);
			products.setSupplier(supplier);
			
			products.setCategoryId(category.getCategoryId());
			products.setBrandId(brand.getBrandId());
			products.setSubcategoryId(subcategory.getSubCategoryId());
			products.setSupplierId(supplier.getSupplierId());
			products.setProductsId(productsServices.generateId());
			productsServices.addProducts(products);
		
			String path = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\";
			path = path + String.valueOf(products.getProductsId()) + ".jpg";
			File file = new File(path);
			MultipartFile multipartFile = products.getProductsImage();
			
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
	
	@RequestMapping("/editProducts-{productsId}")
	public String retriveProducts(@PathVariable("productsId") String productsId, Model model)
	{
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		model.addAttribute("subCategoryList", subCategoryServices.retriveSubCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		model.addAttribute("supplierList", supplierServices.retriveSupplier());
		model.addAttribute("products", productsServices.retriveProducts(productsId));
		return "/productsform";
	}
	
	@RequestMapping("/deleteProducts-{productsId}")
	public String deleteCategory(@PathVariable("productsId") String productsId)
	{
		productsServices.deleteProducts(productsId);
		return "redirect:/productsform";
	}
	
	@RequestMapping("/productInfo-{productsId}")
	public String productInfo(Model model,@PathVariable("productsId") String productsId,@ModelAttribute("productSpecification") ProductSpecification productSpecification)
	{
		productsServices.retriveProducts(productsId);
		productSpecification.setProductsId(productsId);
		model.addAttribute("productsInfo", productSpecification);
		return "/productsspecificationform";
	}
	
	@RequestMapping("/addSpecification")
	public String addSpecification(Model model,@ModelAttribute("productSpecification") ProductSpecification productSpecification)
	{
//		productSpecification.setProductsId(productsId);
		this.productsSpecificationServices.addProductSpecification(productSpecification);
		return "redirect:/productsform";
	}
}
