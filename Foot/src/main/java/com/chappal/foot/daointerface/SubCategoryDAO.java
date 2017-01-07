package com.chappal.foot.daointerface;

import java.util.List;

import com.chappal.foot.model.SubCategory;

public interface SubCategoryDAO 
{
	public void addSubCategory(SubCategory subCategory);
	public List<SubCategory> retriveSubCategory();
	public SubCategory retriveSubCategory(String subCategory_Id);
	public void deleteSubCategory(String subCategory_Id);
	public SubCategory retriveSubCategoryName(String subCategory_Name);
	public int retriveCount();
	public String generateId();
}
