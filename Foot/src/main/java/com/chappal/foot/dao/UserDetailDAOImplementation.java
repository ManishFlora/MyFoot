package com.chappal.foot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chappal.foot.daointerface.UserDetailDAO;
import com.chappal.foot.model.Cart;
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
		user.setUser_Id(userDetail.getUser_Id());
		user.setStatus(true);
		user.setUser_Name(userDetail.getUser_Name());
		user.setUser_Password(userDetail.getUser_Password());
		
		session.saveOrUpdate(user);
		
		Cart cart = new Cart();
		cart.setCart_Id(user.getUser_Id());
		cart.setUser_Id(user.getUser_Id());
		
		session.saveOrUpdate(cart);
		
		UserRole userRole = new UserRole();
		userRole.setRole_Id(1);
		userRole.setUser_Id(user.getUser_Id());
		
		session.saveOrUpdate(userRole);
		userDetail.getBillingAddress().setUserDetail(userDetail);
		session.saveOrUpdate(userDetail.getBillingAddress());
		
		userDetail.getShippingAddress().setUserDetail(userDetail);
		session.saveOrUpdate(userDetail.getShippingAddress());
		
		userDetail.setUser_Id(user.getUser_Id());
		userDetail.setCart_Id(cart.getCart_Id());
		session.saveOrUpdate(userDetail);
		
		session.flush();
	}

}
