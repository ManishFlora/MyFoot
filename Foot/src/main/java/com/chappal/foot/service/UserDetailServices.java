package com.chappal.foot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chappal.foot.dao.UserDetailDAOImplementation;
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
}