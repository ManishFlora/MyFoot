package com.chappal.foot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.CategoryDAO;
import com.chappal.foot.model.Category;
import com.google.gson.Gson;

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

	public Category retriveCategory(int category_Id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category where category_Id = " + category_Id).getResultList();
		return categoryList.get(0);
	}
	
	public Category retriveCategoryName(String category_Name) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Category> categoryList = session.createQuery("from Category where category_Name = " + "'" + category_Name + "'").getResultList();
		return categoryList.get(0);
	}
	
	public void deleteCategory(int category_Id) 
	{
		Category categoryDelete = new Category();
		categoryDelete.setCategory_Id(category_Id);
		sessionFactory.getCurrentSession().delete(categoryDelete);
	}
	
	public String retriveJsonCategory() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category").getResultList();
		Gson gson = new Gson();
		String jsonList = gson.toJson(categoryList);
		return jsonList;
	}
}