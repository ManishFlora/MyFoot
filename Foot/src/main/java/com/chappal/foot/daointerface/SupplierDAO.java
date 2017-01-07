package com.chappal.foot.daointerface;

import java.util.List;

import com.chappal.foot.model.Supplier;
import com.chappal.foot.model.UserDetail;

public interface SupplierDAO 
{
	public void addSupplier(Supplier supplier);
	public List<Supplier> retriveSupplier();
	public Supplier retriveSupplier(String supplier_Id);
	public void deleteSupplier(String supplier_Id);
	public Supplier retriveSupplierName(String supplier_Name);
	public int retriveCount();
	public String generateId();
	public void addRegSupplier(UserDetail userDetail);
}
