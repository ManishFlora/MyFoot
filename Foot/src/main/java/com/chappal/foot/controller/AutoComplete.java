package com.chappal.foot.controller;

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
	String getTags(@RequestParam("subCategoryName") String subCategoryName)
	{
		return simulateSearchResult(subCategoryName);
	}
	
	private String simulateSearchResult(String display) 
	{
		List<ListProducts> result = new ArrayList<ListProducts>();
		List<ListProducts> search = productsServices.retriveList();
		String json = null;
		for (ListProducts listProducts : search) 
		{
			if (listProducts.getSubCategoryName().contains(display)) 
			{
				result.add(listProducts);
			}
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		json=gson.toJson(result);
		return json;
	}
}
