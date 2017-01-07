package com.chappal.foot.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.ProductSpecificationDAO;
import com.chappal.foot.model.ProductSpecification;

@Repository
public class ProductSpecificationDAOImplementation implements ProductSpecificationDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addProductSpecification(ProductSpecification productSpecification) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(productSpecification);
	}

}
