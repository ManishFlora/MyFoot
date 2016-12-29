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
		user.setUserId(userDetail.getUserId());
		user.setStatus(true);
		user.setUserName(userDetail.getUserName());
		user.setUserPassword(userDetail.getUserPassword());
		
		session.saveOrUpdate(user);
		
		Cart cart = new Cart();
		cart.setCartId(user.getUserId());
		cart.setUserId(user.getUserId());
		
		session.saveOrUpdate(cart);
		
		UserRole userRole = new UserRole();
		userRole.setRoleId(1);
		userRole.setUserId(user.getUserId());
		
		session.saveOrUpdate(userRole);
		
		userDetail.getBillingAddress().setUserDetail(userDetail);
		session.saveOrUpdate(userDetail.getBillingAddress());
		
		userDetail.getShippingAddress().setUserDetail(userDetail);
		session.saveOrUpdate(userDetail.getShippingAddress());
		
		userDetail.setUserId(user.getUserId());
		userDetail.setCartId(cart.getCartId());
		session.saveOrUpdate(userDetail);
		
		session.flush();
	}

}
