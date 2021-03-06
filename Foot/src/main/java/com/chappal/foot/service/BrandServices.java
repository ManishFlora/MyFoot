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
	public void updateBrand(Brand brand)
	{
		brandDAOImplementation.updateBrand(brand);
	}
	public List<Brand> retriveBrand() 
	{
		return brandDAOImplementation.retriveBrand();
	}
	public Brand retriveBrand(String brandId)
	{
		return brandDAOImplementation.retriveBrand(brandId);
	}
	public void deleteBrand(String brandId) 
	{
		brandDAOImplementation.deleteBrand(brandId);
	}
	public Brand retriveBrandName(String brandName)
	{
		return brandDAOImplementation.retriveBrandName(brandName);
	}
	
	public String retriveJsonBrand() 
	{
		return brandDAOImplementation.retriveJsonBrand();
	}

	public String generateId()
	{
		return brandDAOImplementation.generateId();
	}
	public int retriveCount(String brandId)
	{
		return brandDAOImplementation.retriveCount(brandId);
	}
}
