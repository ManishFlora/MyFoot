package com.chappal.foot.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.UserDetailDAO;
import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.Cart;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.User;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.model.UserRole;

@Repository
public class UserDetailDAOImplementation implements UserDetailDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addUserDetail(UserDetail userDetail) 
	{
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user.setUserId(userDetail.getUserId());
		user.setStatus(true);
		user.setUserName(userDetail.getUserName());
		user.setUserPassword(userDetail.getUserPassword());
		
		session.saveOrUpdate(user);
		
		Cart cart = new Cart();
		cart.setCartId(generatedCId());
		cart.setUserId(user.getUserId());
		
		session.saveOrUpdate(cart);
		
		UserRole userRole = new UserRole();
		userRole.setRoleId(1);
		userRole.setUserId(user.getUserId());
		
		session.saveOrUpdate(userRole);
		
		userDetail.getBillingAddress().setUserDetail(userDetail);
		userDetail.getBillingAddress().setBillingAddressId(generatedBId());
		session.saveOrUpdate(userDetail.getBillingAddress());
		
		userDetail.getShippingAddress().setUserDetail(userDetail);
		userDetail.getShippingAddress().setShippingAddressId(generatedSId());
		session.saveOrUpdate(userDetail.getShippingAddress());
		
		userDetail.setUserId(user.getUserId());
		userDetail.setCartId(cart.getCartId());
		session.saveOrUpdate(userDetail);
	}

	public int checkUser(String userName) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetail> userList = session.createQuery("from UserDetail where userName = '" + userName + "'").getResultList();
		int count = userList.size();
		return count;
	}
	
	public int checkEmail(String emailId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetail> userList = session.createQuery("from UserDetail where emailId = '" + emailId + "'").getResultList();
		int count = userList.size();
		return count;
	}
	
	public void addUserRegDetail(UserDetail userDetail)
	{
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user.setUserId(userDetail.getUserId());
		user.setStatus(true);
		user.setUserName(userDetail.getUserName());
		user.setUserPassword(userDetail.getUserPassword());
		
		session.saveOrUpdate(user);
		
		Cart cart = new Cart();
		cart.setCartId(generatedCId());
		cart.setUserId(user.getUserId());
		
		session.saveOrUpdate(cart);
		
		UserRole userRole = new UserRole();
		userRole.setRoleId(1);
		userRole.setUserId(user.getUserId());
		
		session.saveOrUpdate(userRole);
		
		userDetail.setUserId(user.getUserId());
		userDetail.setCartId(cart.getCartId());
		
		userDetail.getBillingAddress().setBillingAddressId(generatedBId());
		userDetail.getShippingAddress().setShippingAddressId(generatedSId());
		
		session.saveOrUpdate(userDetail.getBillingAddress());
		session.saveOrUpdate(userDetail.getShippingAddress());

		session.saveOrUpdate(userDetail);		
		session.flush();
	}

	public void updateUser(UserDetail userDetail) 
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String query = "Update User set userPassword = '" + userDetail.getUserPassword() + "' where userName = '" + userDetail.getUserName() + "'";
		int updatedEntities = session.createQuery(query).executeUpdate();
		query = "Update UserDetail set userPassword = '" + userDetail.getUserPassword() + "' where userName = '" + userDetail.getUserName() + "'";
		updatedEntities = session.createQuery(query).executeUpdate();
		transaction.commit();
		session.close();
	}	
	
	public int retriveCount(int userId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetail> userList = session.createQuery("from UserDetail where userId = " + userId).getResultList();
		int count = userList.size();
		return count;
	}

	public UserDetail retriveUserByName(String userName) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetail> userList = session.createQuery("from UserDetail where userName = '" + userName + "'").getResultList();
		if(!userList.isEmpty() && userList != null)
		{
			return userList.get(0);
		}
		else
		{
			return null;
		}
	}

	public ShippingAddress retriveSAddressById(String userId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ShippingAddress> addressList = session.createQuery("from ShippingAddress where userDetail_userId = '" + userId + "'").getResultList();
		if(!addressList.isEmpty() && addressList != null)
		{
			return addressList.get(0);
		}
		else
		{
			return null;
		}
	}

	public BillingAddress retriveBAddressById(String userId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<BillingAddress> addressList = session.createQuery("from BillingAddress where userDetail_userId = '" + userId+ "'").getResultList();
		if(!addressList.isEmpty() && addressList != null)
		{
			return addressList.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public void addShippingAddress(ShippingAddress shippingAddress)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
	}
	
	public  void addBillingAddress(BillingAddress billingAddress)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
	}
	
	public UserDetail retriveUserDeatilsById(String userId)
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetail> userList = session.createQuery("from UserDetail where userId = '" + userId +"'").getResultList();
		return userList.get(0);
	}
	
	public int retriveCount()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetail> userList = session.createQuery("from UserDetail").getResultList();
		int count = userList.size();
		return count;
	}
	
	public int retriveSCount()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ShippingAddress> userList = session.createQuery("from ShippingAddress").getResultList();
		int count = userList.size();
		return count;
	}
	
	public int retriveBCount()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<BillingAddress> userList = session.createQuery("from BillingAddress").getResultList();
		int count = userList.size();
		return count;
	}
	
	public int retriveCCount()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Cart> userList = session.createQuery("from Cart").getResultList();
		int count = userList.size();
		return count;
	}
	
	public String generatedId()
	{
		String id;
		int count = retriveCount() + 1;
		if(count < 10)
		{
			id = "U0000" + count;
		}
		else if(count < 100)
		{
			id = "U000" + count;
		}
		else if(count < 1000)
		{
			id = "U00" + count;
		}
		else if(count < 10000)
		{
			id = "U0" + count;
		}
		else
		{
			id = "U" + count;
		}
		return id;
	}
	
	public String generatedBId()
	{
		String id;
		int count = retriveBCount() + 1;
		if(count < 10)
		{
			id = "BL0000" + count;
		}
		else if(count < 100)
		{
			id = "BL000" + count;
		}
		else if(count < 1000)
		{
			id = "BL00" + count;
		}
		else if(count < 10000)
		{
			id = "BL0" + count;
		}
		else
		{
			id = "BL" + count;
		}
		return id;
	}
	
	public String generatedSId()
	{
		String id;
		int count = retriveSCount() + 1;
		if(count < 10)
		{
			id = "SH0000" + count;
		}
		else if(count < 100)
		{
			id = "SH000" + count;
		}
		else if(count < 1000)
		{
			id = "SH00" + count;
		}
		else if(count < 10000)
		{
			id = "SH0" + count;
		}
		else
		{
			id = "SH" + count;
		}
		return id;
	}
	
	public String generatedCId()
	{
		String id;
		int count = retriveCCount() + 1;
		if(count < 10)
		{
			id = "C0000" + count;
		}
		else if(count < 100)
		{
			id = "C000" + count;
		}
		else if(count < 1000)
		{
			id = "C00" + count;
		}
		else if(count < 10000)
		{
			id = "C0" + count;
		}
		else
		{
			id = "C" + count;
		}
		return id;
	}
	
	public List<User> retriveList()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("FROM User where status = true").getResultList();
		return userList;
	}
	
	public void blockUser(String userName)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String query = "Update User set status = false where userName = '" + userName + "'";
		int updatedEntities = session.createQuery(query).executeUpdate();
		transaction.commit();
		session.close();
	}
}
