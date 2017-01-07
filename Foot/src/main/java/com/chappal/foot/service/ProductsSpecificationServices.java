package com.chappal.foot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.ProductSpecificationDAOImplementation;
import com.chappal.foot.model.ProductSpecification;

@Transactional
@Service
public class ProductsSpecificationServices 
{
	@Autowired
	ProductSpecificationDAOImplementation productSpecificationDAOImplementation;
	
	public void addProductSpecification(ProductSpecification productSpecification)
	{
		productSpecificationDAOImplementation.addProductSpecification(productSpecification);
	}
}
