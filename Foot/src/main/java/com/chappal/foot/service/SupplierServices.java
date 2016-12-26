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

	public Supplier retriveSupplier(int supplier_Id) 
	{
		return supplierDAOImplementation.retriveSupplier(supplier_Id);
	}

	public void deleteSupplier(int supplier_Id) 
	{
		supplierDAOImplementation.deleteSupplier(supplier_Id);
	}
	
	public Supplier retriveSupplierName(String supplier_Name)
	{
		return supplierDAOImplementation.retriveSupplierName(supplier_Name);
	}
	public String retriveJsonSupplier()
	{
		return supplierDAOImplementation.retriveJsonSupplier();
	}
}
