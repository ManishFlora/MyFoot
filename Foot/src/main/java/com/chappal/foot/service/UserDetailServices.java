package com.chappal.foot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.UserDetailDAOImplementation;
import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.User;
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
	public ShippingAddress retriveSAddressById(String userId) 
	{
		return userDetailDAOImplementation.retriveSAddressById(userId);
	}

	public BillingAddress retriveBAddressById(String userId) 
	{
		return userDetailDAOImplementation.retriveBAddressById(userId);
	}
	public void addShippingAddress(ShippingAddress shippingAddress)
	{
		userDetailDAOImplementation.addShippingAddress(shippingAddress);
	}
	public  void addBillingAddress(BillingAddress billingAddress)
	{
		userDetailDAOImplementation.addBillingAddress(billingAddress);
	}
	public UserDetail retriveUserDeatilsById(String userId)
	{
		return userDetailDAOImplementation.retriveUserDeatilsById(userId);
	}
	public String generatedId()
	{
		return userDetailDAOImplementation.generatedId();
	}
	
	public String generatedCId()
	{
		return userDetailDAOImplementation.generatedCId();
	}
	
	public List<User> retriveList()
	{
		return userDetailDAOImplementation.retriveList();
	}
	
	public void blockUser(String userName)
	{
		userDetailDAOImplementation.blockUser(userName);
	}
}
