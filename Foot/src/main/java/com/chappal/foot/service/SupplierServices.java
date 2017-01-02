package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.SupplierDAOImplementation;
import com.chappal.foot.model.Supplier;;

@Transactional
@Service
public class SupplierServices 
{
	@Autowired
	SupplierDAOImplementation supplierDAOImplementation;
	public void addSupplier(Supplier supplier) 
	{
		supplierDAOImplementation.addSupplier(supplier);
	}

	public List<Supplier> retriveSupplier() 
	{
		return supplierDAOImplementation.retriveSupplier();
	}

	public Supplier retriveSupplier(int supplierId) 
	{
		return supplierDAOImplementation.retriveSupplier(supplierId);
	}

	public void deleteSupplier(int supplierId) 
	{
		supplierDAOImplementation.deleteSupplier(supplierId);
	}
	
	public Supplier retriveSupplierName(String supplierName)
	{
		return supplierDAOImplementation.retriveSupplierName(supplierName);
	}
	public String retriveJsonSupplier()
	{
		return supplierDAOImplementation.retriveJsonSupplier();
	}
}
