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

	public List<SubCategory> retriveSubCategory() 
	{
		return subCategoryDAOImplementation.retriveSubCategory();
	}

	public SubCategory retriveSubCategory(int subCategory_Id) 
	{
		return subCategoryDAOImplementation.retriveSubCategory(subCategory_Id);
	}

	public void deleteSubCategory(int subCategory_Id) 
	{
		subCategoryDAOImplementation.deleteSubCategory(subCategory_Id);
	}
	
	public SubCategory retriveSubCategoryName(String subCategory_Name)
	{
		return subCategoryDAOImplementation.retriveSubCategoryName(subCategory_Name);
	}
	
	public String retriveJsonSubCategory()
	{
		return subCategoryDAOImplementation.retriveJsonSubCategory();
	}
}
