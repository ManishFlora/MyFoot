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
		
		session.save(user);
		
		Cart cart = new Cart();
		cart.setCartId(user.getUserId());
		cart.setUserId(user.getUserId());
		
		session.save(cart);
		
		UserRole userRole = new UserRole();
		userRole.setRoleId(1);
		userRole.setUserId(user.getUserId());
		
		session.save(userRole);
		
		userDetail.getBillingAddress().setUserDetail(userDetail);
		session.save(userDetail.getBillingAddress());
		
		userDetail.getShippingAddress().setUserDetail(userDetail);
		session.save(userDetail.getShippingAddress());
		
		userDetail.setUserId(user.getUserId());
		userDetail.setCartId(cart.getCartId());
		session.save(userDetail);
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
		
		session.save(user);
		
		Cart cart = new Cart();
		cart.setCartId(user.getUserId());
		cart.setUserId(user.getUserId());
		
		session.save(cart);
		
		UserRole userRole = new UserRole();
		userRole.setRoleId(1);
		userRole.setUserId(user.getUserId());
		
		session.save(userRole);
		
		userDetail.setUserId(user.getUserId());
		userDetail.setCartId(cart.getCartId());
		
		session.save(userDetail.getBillingAddress());
		session.save(userDetail.getShippingAddress());

		session.save(userDetail);		
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
		List<UserDetail> userList = session.createQuery("from UserDetail where userId = '" + userId + "'").getResultList();
		int count = userList.size();
		return count;
	}

	public UserDetail retriveUserByName(String userName) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetail> userList = session.createQuery("from UserDetail where userName = '" + userName + "'").getResultList();
		return userList.get(0);
	}

	public ShippingAddress retriveSAddressById(int userId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ShippingAddress> addressList = session.createQuery("from ShippingAddress where userDetail_userId = " + userId).getResultList();
		return addressList.get(0);
	}

	public BillingAddress retriveBAddressById(int userId) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<BillingAddress> addressList = session.createQuery("from BillingAddress where userDetail_userId = " + userId).getResultList();
		return addressList.get(0);
	}
}
