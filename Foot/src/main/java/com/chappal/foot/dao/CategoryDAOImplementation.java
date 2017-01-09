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

	public Category retriveCategory(String categoryId) 
	{	
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category where categoryId = ' " + categoryId + "'").getResultList();
		return categoryList.get(0);
	}
	
	public Category retriveCategoryName(String categoryName) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Category> categoryList = session.createQuery("from Category where categoryName = " + "'" + categoryName + "'").getResultList();
		return categoryList.get(0);
	}
	
	public void deleteCategory(String category_Id) 
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
	
	public int retriveCount()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category").getResultList();
		int count = categoryList.size();
		return count;
	}
	
	public int retriveCount(String categoryId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category where categoryId = '" + categoryId + "'").getResultList();
		int count = categoryList.size();
		return count;
	}
	
	public String generateId()
	{
		String id;
		int count = retriveCount() + 1;
		if(count < 10)
		{
			id = "C0000" + count;
		}
		else if(count < 100)
		{
			id = "C000" + count;
		}
		else if(count < 1000)
		{
			id = "C00" + count;
		}
		else if(count < 10000)
		{
			id = "C0" + count;
		}
		else
		{
			id = "C" + count;
		}
		return id;
	}

	public void updateCategory(Category category) 
	{
		sessionFactory.getCurrentSession().update(category);
	}
}