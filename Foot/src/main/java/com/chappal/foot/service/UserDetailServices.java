package com.chappal.foot.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.UserDetailDAOImplementation;
import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.UserDetail;

@Transactional
@Service
public class UserDetailServices 
{
	@Autowired
	UserDetailDAOImplementation userDetailDAOImplementation;
	
	public void addUserDetail(UserDetail userDetail) 
	{
		userDetailDAOImplementation.addUserDetail(userDetail);
	}
	public void updateUserDetail(UserDetail userDetail) 
	{
		userDetailDAOImplementation.updateUser(userDetail);
	}
	public int checkUser(String userName)
	{
		return userDetailDAOImplementation.checkUser(userName);
	}
	public int checkEmail(String emailId)
	{
		return userDetailDAOImplementation.checkEmail(emailId);
	}
	public void addUserRegDetail(UserDetail userDetail)
	{
		userDetailDAOImplementation.addUserRegDetail(userDetail);
	}
	public int retriveCount(int userId)
	{
		return userDetailDAOImplementation.retriveCount(userId);
	}
	public UserDetail retriveUserByName(String userName)
	{
		return userDetailDAOImplementation.retriveUserByName(userName);
	}
	public ShippingAddress retriveSAddressById(int userId) 
	{
		return userDetailDAOImplementation.retriveSAddressById(userId);
	}

	public BillingAddress retriveBAddressById(int userId) 
	{
		return userDetailDAOImplementation.retriveBAddressById(userId);
	}
}
