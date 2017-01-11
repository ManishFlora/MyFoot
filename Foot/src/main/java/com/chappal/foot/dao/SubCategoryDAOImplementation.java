package com.chappal.foot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.SubCategoryDAO;
import com.chappal.foot.model.SubCategory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

	public SubCategory retriveSubCategory(String subCategoryId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session.createQuery("from SubCategory where subcategoryId = '" + subCategoryId + "'").getResultList();
		if(subCategoryList!=null && !subCategoryList.isEmpty())
		{
			return subCategoryList.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public void deleteSubCategory(String subCategoryId) 
	{
		SubCategory subCategoryDelete = new SubCategory();
		subCategoryDelete.setSubCategoryId(subCategoryId);
		sessionFactory.getCurrentSession().delete(subCategoryDelete);
	}

	public SubCategory retriveSubCategoryName(String subCategoryName) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session.createQuery("from SubCategory where subcategoryName = "+ "'" + subCategoryName + "'").getResultList();
		if(subCategoryList!=null && !subCategoryList.isEmpty())
		{
			return subCategoryList.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public String retriveJsonSubCategory()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList = session.createQuery("from SubCategory").getResultList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(subCategoryList);
		return json;
	}
	
	public int retriveCount() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> brandList = session.createQuery("from SubCategory").getResultList();
		int count = brandList.size();
		return count;
	}
	
	public int retriveCount(String subCategoryId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subcategoryList = session.createQuery("from SubCategory where subCategoryId = '" + subCategoryId + "'").getResultList();
		int count = subcategoryList.size();
		return count;
	}
	
	public String generateId()
	{
		String id;
		int count = retriveCount() + 1;
		if(count < 10)
		{
			id = "SC0000" + count;
		}
		else if(count < 100)
		{
			id = "SC000" + count;
		}
		else if(count < 1000)
		{
			id = "SC00" + count;
		}
		else if(count < 10000)
		{
			id = "SC0" + count;
		}
		else
		{
			id = "SC" + count;
		}
		return id;
	}

	public void updateSubCategory(SubCategory subCategory) 
	{
		sessionFactory.getCurrentSession().update(subCategory);
	}
}
