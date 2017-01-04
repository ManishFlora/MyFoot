package com.chappal.foot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.CategoryDAO;
import com.chappal.foot.model.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Repository
public class CategoryDAOImplementation implements CategoryDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	public void addCategory(Category category) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}
	
	public List<Category> retriveCategory() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category").getResultList();
		return categoryList;
	}

	public Category retriveCategory(int categoryId) 
	{	
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category where categoryId = " + categoryId).getResultList();
		return categoryList.get(0);
	}
	
	public Category retriveCategoryName(String categoryName) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Category> categoryList = session.createQuery("from Category where categoryName = " + "'" + categoryName + "'").getResultList();
		return categoryList.get(0);
	}
	
	public void deleteCategory(int category_Id) 
	{
		Category categoryDelete = new Category();
		categoryDelete.setCategoryId(category_Id);
		sessionFactory.getCurrentSession().delete(categoryDelete);
	}
	
	public String retriveJsonCategory() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category").getResultList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonList = gson.toJson(categoryList);
		return jsonList;
	}
}