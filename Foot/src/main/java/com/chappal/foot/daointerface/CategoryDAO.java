package com.chappal.foot.daointerface;

import java.util.List;

import com.chappal.foot.model.Category;

public interface CategoryDAO 
{
	public void addCategory(Category category);
	public List<Category> retriveCategory();
	public Category retriveCategory(String category_Id);
	public void deleteCategory(String category_Id);
	public Category retriveCategoryName(String category_Name);
	public int retriveCount();
	public String generateId();
}
