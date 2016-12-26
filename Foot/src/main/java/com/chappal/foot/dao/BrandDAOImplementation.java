package com.chappal.foot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.BrandDAO;
import com.chappal.foot.model.Brand;
import com.google.gson.Gson;

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

	public Brand retriveBrand(int brand_Id) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList = session.createQuery("from Brand where brand_Id = " + brand_Id).getResultList();
		return brandList.get(0);
	}

	public void deleteBrand(int brand_Id) 
	{
		Brand brandDelete = new Brand();
		brandDelete.setBrand_Id(brand_Id);
		sessionFactory.getCurrentSession().delete(brandDelete);
	}

	public Brand retriveBrandName(String brand_Name) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Brand> brandList = session.createQuery("from Brand where brand_Name = " + "'" + brand_Name + "'").getResultList();
		return brandList.get(0);
	}
	
	public String retriveJsonBrand() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList = session.createQuery("from Brand").getResultList();
		Gson gson = new Gson();
		String json = gson.toJson(brandList);
		return json;
	}
}
