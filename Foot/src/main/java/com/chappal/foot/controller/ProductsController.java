package com.chappal.foot.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chappal.foot.model.Brand;
import com.chappal.foot.model.Category;
import com.chappal.foot.model.ListProducts;
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
import com.chappal.foot.service.UserDetailServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	@Autowired
	UserDetailServices userDetailServices;
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
	public String addProducts(Model model,@Valid @ModelAttribute("products") Products products,BindingResult result,String productsId,@RequestParam("fileUpload") List<MultipartFile> productImage)
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
			productsId = products.getProductsId();
			int count = productsServices.retriveCount(productsId);
			if(count == 1)
			{
				productsServices.updateProducts(products);
			}
			else
			{
				products.setProductsId(productsServices.generateId());
				productsServices.addProducts(products);
			}
			List<MultipartFile> files = productImage;
			
			if(!files.isEmpty())
			{
				for(int i = 0;i<files.size();i++)
				{
					try 
					{
						MultipartFile multipartFile = files.get(i);
						String path = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\products\\";
						path = path + String.valueOf(products.getProductsId()) + "(" + (i + 1) + ")" + ".jpg";
						File file = new File(path);
						if(file.exists())
						{
							file.delete();
						}
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
	public String addSpecification(Model model,@ModelAttribute("productSpecification") ProductSpecification productSpecification,@RequestParam("fileUpload") List<MultipartFile> productImage)
	{
		this.productsSpecificationServices.addProductSpecification(productSpecification);
		List<MultipartFile> files = productImage;
		
		if(!files.isEmpty())
		{
			for(int i = 0;i<files.size();i++)
			{
				try 
				{
					MultipartFile multipartFile = files.get(i);
					String path = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\view\\";
					path = path + String.valueOf(productSpecification.getProductsId()) + "(" + (i + 1) + ")" + ".jpg";
					File file = new File(path);
					if(file.exists())
					{
						file.delete();
					}
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
		}
		else
		{
			System.out.println("Sorry You are Dumped.");
		}
		return "redirect:/productsform";
	}
	
	@RequestMapping("/viewproduct-{productsId}")
	public String viewProduct(Model model,@PathVariable("productsId") String productsId)
	{
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(productsServices.retriveListProducts(productsId));
		model.addAttribute("listView", json);
		return "/viewproduct";
	}
	@RequestMapping("/productssupplierform")
	public String productsSupplier(Model model)
	{
		model.addAttribute("products", new Products());
		model.addAttribute("subcategory", new SubCategory());
		model.addAttribute("category", new Category());
		model.addAttribute("brand", new Brand());
		
		model.addAttribute("subCategoryList", subCategoryServices.retriveSubCategory());
		model.addAttribute("brandList", brandServices.retriveBrand());
		model.addAttribute("productsJsonList", productsServices.retriveJsonProducts());
		model.addAttribute("categoryList", categoryServices.retriveCategory());
		return "/productssupplierform";
	}
	@RequestMapping("/addproductsSupplier")
	public String addproductsSupplier(Model model,@Valid @ModelAttribute("products") Products products,BindingResult result,String productsId,@RequestParam("fileUpload") List<MultipartFile> productImage)
	{
		if(result.hasErrors())
		{
			model.addAttribute("subCategoryList", subCategoryServices.retriveSubCategory());
			model.addAttribute("brandList", brandServices.retriveBrand());
			model.addAttribute("supplierList", supplierServices.retriveSupplier());
			model.addAttribute("productsJsonList", productsServices.retriveJsonProducts());
			model.addAttribute("categoryList", categoryServices.retriveCategory());
			return "/productssupplierform";
		}
		else
		{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String userName = authentication.getName();
			String userId = userDetailServices.retriveUserByName(userName).getUserId();
			Category category = categoryServices.retriveCategoryName(products.getCategory().getCategoryName());
			Supplier supplier = supplierServices.retriveSupplierByUserId(userId);
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
			productsId = products.getProductsId();
			int count = productsServices.retriveCount(productsId);
			if(count == 1)
			{
				productsServices.updateProducts(products);
			}
			else
			{
				products.setProductsId(productsServices.generateId());
				productsServices.addProducts(products);
			}
			List<MultipartFile> files = productImage;
			
			if(!files.isEmpty())
			{
				for(int i = 0;i<=files.size();i++)
				{
					try 
					{
						MultipartFile multipartFile = files.get(i);
						String path = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\products\\";
						path = path + String.valueOf(products.getProductsId()) + "(" + (i + 1) + ")" + ".jpg";
						File file = new File(path);
						if(file.exists())
						{
							file.delete();
						}
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
			}
			else
			{
				System.out.println("Sorry You are Dumped.");
			}
			return "redirect:/productssupplierform";
	}
}
}
