package com.chappal.foot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.SupplierDAO;
import com.chappal.foot.model.Supplier;
import com.google.gson.Gson;

@Repository
public class SupplierDAOImplementation implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public void addSupplier(Supplier supplier) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}

	public List<Supplier> retriveSupplier() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier").getResultList();
		return supplierList;
	}

	public Supplier retriveSupplier(int supplierId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier where supplierId = " + supplierId).getResultList();
		return supplierList.get(0);
	}

	public void deleteSupplier(int supplierId) 
	{
		Supplier supplierDelete = new Supplier();
		supplierDelete.setSupplierId(supplierId);
		sessionFactory.getCurrentSession().delete(supplierDelete);
	}

	public Supplier retriveSupplierName(String supplierName) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier where supplierName = " + "'" + supplierName + "'").getResultList();
		return supplierList.get(0);
	}
	
	public String retriveJsonSupplier() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier").getResultList();
		Gson gson = new Gson();
		String jsonList = gson.toJson(supplierList);
		return jsonList;
	}
}
