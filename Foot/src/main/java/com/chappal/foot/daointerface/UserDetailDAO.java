package com.chappal.foot.daointerface;

import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.UserDetail;

public interface UserDetailDAO 
{
	public void addUserDetail(UserDetail userDetail);
	public int checkUser(String userName);
	public void updateUser(UserDetail userDetail);
	public int checkEmail(String emailId);
	public void addUserRegDetail(UserDetail userDetail);
	public UserDetail retriveUserByName(String userName);
	public ShippingAddress retriveSAddressById(String userId);
	public BillingAddress retriveBAddressById(String userId);
}
