package com.chappal.foot.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chappal.foot.model.ListProducts;
import com.chappal.foot.service.ProductsServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class AutoComplete 
{
	@Autowired
	ProductsServices productsServices;
	
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody
	String getTags(@RequestParam("searchkeyword") String searchkeyword)
	{
		return simulateSearchResult(searchkeyword);
	}
	
	private String simulateSearchResult(String display) 
	{
		List<ListProducts> result = new ArrayList<ListProducts>();
		List<ListProducts> search = productsServices.retriveList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = display;
		for (ListProducts listProducts : search) 
		{
			if (listProducts.getSubCategoryName().toLowerCase().contains(display.toLowerCase())) 
			{
				result.add(listProducts);
			}
			else if(listProducts.getBrandName().toLowerCase().contains(display.toLowerCase()))
			{
				result.add(listProducts);
			}
			else if(listProducts.getProductsName().toLowerCase().contains(display.toLowerCase()))
			{
				result.add(listProducts);
			}
			else if(listProducts.getCategoryName().toLowerCase().contains(display.toLowerCase()))
			{
				result.add(listProducts);
			}
		} 
		json = gson.toJson(result);
		return json;
	}
}
