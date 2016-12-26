package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.BrandDAOImplementation;
import com.chappal.foot.model.Brand;

@Transactional
@Service
public class BrandServices 
{
	@Autowired
	BrandDAOImplementation brandDAOImplementation;
	
	public void addBrand(Brand brand) 
	{
		brandDAOImplementation.addBrand(brand);
	}
	public List<Brand> retriveBrand() 
	{
		return brandDAOImplementation.retriveBrand();
	}
	public Brand retriveBrand(int brand_Id)
	{
		return brandDAOImplementation.retriveBrand(brand_Id);
	}
	public void deleteBrand(int brand_Id) 
	{
		brandDAOImplementation.deleteBrand(brand_Id);
	}
	public Brand retriveBrandName(String brand_Name)
	{
		return brandDAOImplementation.retriveBrandName(brand_Name);
	}
	
	public String retriveJsonBrand() 
	{
		return brandDAOImplementation.retriveJsonBrand();
	}
}
