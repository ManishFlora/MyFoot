package com.chappal.foot.daointerface;

import com.chappal.foot.model.UserDetail;

public interface UserDetailDAO 
{
	public void addUserDetail(UserDetail userDetail);
	public int checkUser(String userName);
}
