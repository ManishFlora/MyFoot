package com.chappal.foot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.SubCategoryDAO;
import com.chappal.foot.model.SubCategory;
import com.google.gson.Gson;

@Repository
public class SubCategoryDAOImplementation implements SubCategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addSubCategory(SubCategory subCategory) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(subCategory);
	}

	public List<SubCategory> retriveSubCategory() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session.createQuery("from SubCategory").getResultList();
		return subCategoryList;
	}

	public SubCategory retriveSubCategory(int subCategory_Id) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session.createQuery("from SubCategory where subcategory_Id = " + subCategory_Id).getResultList();
		return subCategoryList.get(0);
	}
	
	public void deleteSubCategory(int subCategory_Id) 
	{
		SubCategory subCategoryDelete = new SubCategory();
		subCategoryDelete.setSubCategoryId(subCategory_Id);
		sessionFactory.getCurrentSession().delete(subCategoryDelete);
	}

	public SubCategory retriveSubCategoryName(String subCategory_Name) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session.createQuery("from SubCategory where subcategory_Name = "+ "'" + subCategory_Name + "'").getResultList();
		return subCategoryList.get(0);
	}
	
	public String retriveJsonSubCategory()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session.createQuery("from SubCategory").getResultList();
		Gson gson = new Gson();
		String json = gson.toJson(subCategoryList);
		return json;
	}
}
