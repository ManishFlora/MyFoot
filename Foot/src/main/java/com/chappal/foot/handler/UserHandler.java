package com.chappal.foot.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.chappal.foot.model.UserDetail;
import com.chappal.foot.service.UserDetailServices;

@Component
public class UserHandler 
{
	@Autowired
	UserDetailServices userDetailServices;
	
	public UserDetail initFlow() 
	{
		return new UserDetail();
	}
	
	public String validateUser(UserDetail userDetail, MessageContext message)
	{
		String status= "success";
		if(userDetail.getUserName().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("userName").defaultText("Please provide UserName.").build());
			status = "failure";
		}
		else
		{
			status = "success";
		}
		return status;
	}
	public String checkUser(UserDetail userDetail,MessageContext message)
	{
		String status= "success";
		int countUser = userDetailServices.checkUser(userDetail.getUserName());
		if(countUser == 1)
		{
			status = "success";
		}
		else
		{
			message.addMessage(new MessageBuilder().error().source("userName").defaultText("UserName not found").build());
			status = "failure";
		}
		return status;
	}
	
	public void updateUser(UserDetail userDetail)
	{
		userDetailServices.updateUserDetail(userDetail);
	}
}
