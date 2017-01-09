package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.SubCategoryDAOImplementation;
import com.chappal.foot.model.SubCategory;

@Service
@Transactional
public class SubCategoryServices 
{
	@Autowired
	SubCategoryDAOImplementation subCategoryDAOImplementation;
	public void addSubCategory(SubCategory subCategory) 
	{
		subCategoryDAOImplementation.addSubCategory(subCategory);
	}
	public void updateSubcategory(SubCategory subCategory)
	{
		subCategoryDAOImplementation.updateSubCategory(subCategory);
	}
	public List<SubCategory> retriveSubCategory() 
	{
		return subCategoryDAOImplementation.retriveSubCategory();
	}

	public SubCategory retriveSubCategory(String subCategoryId) 
	{
		return subCategoryDAOImplementation.retriveSubCategory(subCategoryId);
	}

	public void deleteSubCategory(String subCategoryId) 
	{
		subCategoryDAOImplementation.deleteSubCategory(subCategoryId);
	}
	
	public SubCategory retriveSubCategoryName(String subCategoryName)
	{
		return subCategoryDAOImplementation.retriveSubCategoryName(subCategoryName);
	}
	
	public String retriveJsonSubCategory()
	{
		return subCategoryDAOImplementation.retriveJsonSubCategory();
	}
	
	public String generateId()
	{
		return subCategoryDAOImplementation.generateId();
	}
	
	public int retriveCount(String subCategoryId)
	{
		return subCategoryDAOImplementation.retriveCount(subCategoryId);
	}
}
