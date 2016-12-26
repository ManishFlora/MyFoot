package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.CategoryDAOImplementation;
import com.chappal.foot.model.Category;

@Transactional
@Service
public class CategoryServices 
{
	@Autowired
	CategoryDAOImplementation categoryDAOImplementation;
	
	public void addCategory(Category category) 
	{
		categoryDAOImplementation.addCategory(category);
	}
	public List<Category> retriveCategory() 
	{
		return categoryDAOImplementation.retriveCategory();
	}
	public Category retriveCategory(int category_Id)
	{
		return categoryDAOImplementation.retriveCategory(category_Id);
	}
	public void deleteCategory(int category_Id) 
	{
		categoryDAOImplementation.deleteCategory(category_Id);
	}
	public Category retriveCategoryName(String category_Name)
	{
		return categoryDAOImplementation.retriveCategoryName(category_Name);
	}
	public String retriveJsonCategory()
	{
		return categoryDAOImplementation.retriveJsonCategory();
	}
}
