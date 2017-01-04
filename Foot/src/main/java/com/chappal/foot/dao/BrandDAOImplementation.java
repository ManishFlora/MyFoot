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
		sessionFactory.getCurrentSession().saveOrUpdate(brand);
	}

	public List<Brand> retriveBrand() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList = session.createQuery("from Brand").getResultList();
		return brandList;
	}

	public Brand retriveBrand(int brandId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList = session.createQuery("from Brand where brandId = " + brandId).getResultList();
		return brandList.get(0);
	}

	public void deleteBrand(int brandId) 
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
		return brandList.get(0);
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
}
