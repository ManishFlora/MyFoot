package com.chappal.foot.daointerface;

import java.util.List;

import com.chappal.foot.model.Brand;


public interface BrandDAO 
{
	public void addBrand(Brand brand);
	public List<Brand> retriveBrand();
	public Brand retriveBrand(int brand_Id);
	public void deleteBrand(int brand_Id);
	public Brand retriveBrandName(String brand_Name);
}
