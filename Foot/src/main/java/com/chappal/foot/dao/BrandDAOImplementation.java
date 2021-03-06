package com.chappal.foot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.BrandDAO;
import com.chappal.foot.model.Brand;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Repository
public class BrandDAOImplementation implements BrandDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addBrand(Brand brand) 
	{
		sessionFactory.getCurrentSession().save(brand);
	}

	public List<Brand> retriveBrand() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList = session.createQuery("from Brand").getResultList();
		return brandList;
	}

	public Brand retriveBrand(String brandId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList = session.createQuery("from Brand where brandId = '" + brandId + "'").getResultList();
		if(!brandList.isEmpty() && brandList != null)
		{
			return brandList.get(0);
		}
		else
		{
			return null;
		}
	}

	public void deleteBrand(String brandId) 
	{
		Brand brandDelete = new Brand();
		brandDelete.setBrandId(brandId);
		sessionFactory.getCurrentSession().delete(brandDelete);
	}

	public Brand retriveBrandName(String brandName) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Brand> brandList = session.createQuery("from Brand where brandName = " + "'" + brandName + "'").getResultList();
		if(!brandList.isEmpty() && brandList != null)
		{
			return brandList.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public String retriveJsonBrand() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList = session.createQuery("from Brand").getResultList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(brandList);
		return json;
	}

	public int retriveCount() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList = session.createQuery("from Brand").getResultList();
		int count = brandList.size();
		return count;
	}
	
	public int retriveCount(String brandId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList = session.createQuery("from Brand where brandId = '" + brandId + "'").getResultList();
		int count = brandList.size();
		return count;
	}
	
	public String generateId()
	{
		String id;
		int count = retriveCount() + 1;
		if(count < 10)
		{
			id = "B0000" + count;
		}
		else if(count < 100)
		{
			id = "B000" + count;
		}
		else if(count < 1000)
		{
			id = "B00" + count;
		}
		else if(count < 10000)
		{
			id = "B0" + count;
		}
		else
		{
			id = "B" + count;
		}
		return id;
	}

	public void updateBrand(Brand brand) 
	{
		sessionFactory.getCurrentSession().update(brand);
	}
}
