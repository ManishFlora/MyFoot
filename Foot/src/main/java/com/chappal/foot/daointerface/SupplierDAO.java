package com.chappal.foot.daointerface;

import java.util.List;

import com.chappal.foot.model.Supplier;

public interface SupplierDAO 
{
	public void addSupplier(Supplier supplier);
	public List<Supplier> retriveSupplier();
	public Supplier retriveSupplier(int supplier_Id);
	public void deleteSupplier(int supplier_Id);
	public Supplier retriveSupplierName(String supplier_Name);
}
