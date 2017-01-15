package com.chappal.foot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chappal.foot.model.SubCategory;
import com.chappal.foot.service.SubCategoryServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class AutoComplete 
{
	@Autowired
	SubCategoryServices subCategoryServices;
	
	@RequestMapping("/getTags")
	public String getTags(@RequestParam("subCategoryName") String subCategoryName)
	{
		return simulateSearchResult(subCategoryName);
	}
	
	private String simulateSearchResult(String subCategoryName) 
	{
		List<SubCategory> result = new ArrayList<SubCategory>();
		List<SubCategory> data = subCategoryServices.retriveSubCategory();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = null;
		for (SubCategory subCategory : data) 
		{
			if (subCategory.getSubCategoryName().contains(subCategoryName)) 
			{
				result.add(subCategory);
				json=gson.toJson(result);
			}
		}
		return json;
	}
}
