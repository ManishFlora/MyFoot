package com.chappal.foot.daointerface;

import java.util.List;

import com.chappal.foot.model.Brand;


public interface BrandDAO 
{
	public void addBrand(Brand brand);
	public void updateBrand(Brand brand);
	public List<Brand> retriveBrand();
	public Brand retriveBrand(String brand_Id);
	public void deleteBrand(String brand_Id);
	public Brand retriveBrandName(String brand_Name);
	public int retriveCount();
	public String generateId();
}
