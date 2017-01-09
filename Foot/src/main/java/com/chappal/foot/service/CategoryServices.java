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
	public void updateCategory(Category category)
	{
		categoryDAOImplementation.updateCategory(category);
	}
	public List<Category> retriveCategory() 
	{
		return categoryDAOImplementation.retriveCategory();
	}
	public Category retriveCategory(String categoryId)
	{
		return categoryDAOImplementation.retriveCategory(categoryId);
	}
	public void deleteCategory(String categoryId) 
	{
		categoryDAOImplementation.deleteCategory(categoryId);
	}
	public Category retriveCategoryName(String categoryName)
	{
		return categoryDAOImplementation.retriveCategoryName(categoryName);
	}
	public String retriveJsonCategory()
	{
		return categoryDAOImplementation.retriveJsonCategory();
	}
	public String generateId()
	{
		return categoryDAOImplementation.generateId();
	}
	public int retriveCount(String categoryId)
	{
		return categoryDAOImplementation.retriveCount(categoryId);
	}
}
