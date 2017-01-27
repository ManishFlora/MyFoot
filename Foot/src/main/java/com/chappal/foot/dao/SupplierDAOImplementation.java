package com.chappal.foot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.SupplierDAO;
import com.chappal.foot.model.Cart;
import com.chappal.foot.model.Supplier;
import com.chappal.foot.model.User;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.model.UserRole;
import com.chappal.foot.service.UserDetailServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Repository
public class SupplierDAOImplementation implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	UserDetailServices userDetailServices;
	
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

	public Supplier retriveSupplier(String supplierId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier where supplierId = '" + supplierId + "' and flag = true").getResultList();
		if(supplierList != null && !supplierList.isEmpty())
		{
			return supplierList.get(0);
		}
		else
		{
			return null;
		}
	}

	public void deleteSupplier(String supplierId) 
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
		if(!supplierList.isEmpty() && supplierList != null)
		{
			return supplierList.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public String retriveJsonSupplier() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier").getResultList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonList = gson.toJson(supplierList);
		return jsonList;
	}
	
	public int retriveCount() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier").getResultList();
		int count = supplierList.size();
		return count;
	}
	
	public int retriveCount(String supplierId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier where supplierId = '" + supplierId + "'").getResultList();
		int count = supplierList.size();
		return count;
	}
	
	public String generateId()
	{
		String id;
		int count = retriveCount() + 1;
		if(count < 10)
		{
			id = "S0000" + count;
		}
		else if(count < 100)
		{
			id = "S000" + count;
		}
		else if(count < 1000)
		{
			id = "S00" + count;
		}
		else if(count < 10000)
		{
			id = "S0" + count;
		}
		else
		{
			id = "S" + count;
		}
		return id;
	}

	public void addRegSupplier(UserDetail userDetail) 
	{
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user.setUserId(userDetail.getUserId());
		user.setStatus(true);
		user.setUserName(userDetail.getUserName());
		user.setUserPassword(userDetail.getUserPassword());
		
		session.saveOrUpdate(user);
		
		Cart cart = new Cart();
		cart.setCartId(userDetailServices.generatedCId());
		cart.setUserId(user.getUserId());
		
		session.saveOrUpdate(cart);
		
		UserRole userRole = new UserRole();
		userRole.setRoleId(2);
		userRole.setUserId(user.getUserId());
		
		session.saveOrUpdate(userRole);
		
		userDetail.setUserId(user.getUserId());
		userDetail.setCartId(cart.getCartId());
		
		session.saveOrUpdate(userDetail);		
		session.flush();
	}

	public void updateSupplier(Supplier supplier) 
	{
		sessionFactory.getCurrentSession().update(supplier);
	}
	
	public Supplier retriveSupplierByUserId(String userId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier where UserDetail_userId = '" + userId + "'").getResultList();
		if(!supplierList.isEmpty() && supplierList != null)
		{
			return supplierList.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public List<Supplier> retriveList() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = session.createQuery("from Supplier where flag = false").getResultList();
		return supplierList;
	}
	
	public void updateFlag(String supplierId)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String query = "Update Supplier set flag = true where supplierId = '" + supplierId + "'";
		int updatedEntities = session.createQuery(query).executeUpdate();
		transaction.commit();
		session.close();
	}
}
