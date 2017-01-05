package com.chappal.foot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.Message;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageCriteria;
import org.springframework.binding.message.MessageResolver;
import org.springframework.stereotype.Component;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.service.UserDetailServices;

@Component
public class RegistrationHandler 
{
	@Autowired
	UserDetailServices userDetailServices;

	public UserDetail initFlow() 
	{
		return new UserDetail();
	}
	
	public String validateUser(UserDetail userDetail, MessageContext message)
	{
		String status = "success";
		
		if(userDetail.getUserName().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("userName").defaultText("Field cant be Empty").build());
			status = "failure";
		}
		else
		{
			status = "success";
		}
		
		if(userDetail.getUserPassword().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("userPassword").defaultText("Field cant be Empty").build());
			status = "failure";
		}
		else if(userDetail.getUserPassword().matches("(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,10})$"))
		{
			status = "success";
		}
		else
		{
			message.addMessage(new MessageBuilder().error().source("userPassword").defaultText("Invalid Pattern").build());
			status = "failure";
		}
		
		if(userDetail.getFirstName().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("firstName").defaultText("Field cant be Empty").build());
			status= "failure";
		}
		else
		{
			status= "failure";
		}
		
		if(userDetail.getLastName().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("lastName").defaultText("Field cant be Empty").build());
			status= "failure";
		}
		else
		{
			status= "failure";
		}
		
		if(userDetail.getEmailId().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("emailId").defaultText("Field cant be Empty").build());
			status= "failure";
		}
		else if(userDetail.getEmailId().matches(".+@.+\\..+"))
		{
			status = "success";
		}
		else
		{
			status= "failure";
		}
		
		if(userDetail.getContactNumber().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("contactNumber").defaultText("Field cant be Empty").build());
			status= "failure";
		}
		else if(userDetail.getContactNumber().length() == 10 && userDetail.getContactNumber().matches("[0-9]+"))
		{
			status = "success";
		}
		else
		{
			status= "failure";
		}
		
		return status;
	}
	
	public String checkUser(UserDetail userDetail,MessageContext message)
	{
		String status = "success";
		int count = userDetailServices.checkUser(userDetail.getUserName());
		if(count == 1)
		{
			message.addMessage(new MessageBuilder().error().source("userName").defaultText("User already exsist.").build());
			status = "failure";
		}
		else
		{
			if(validateUser(userDetail, message) == "success")
			{
				status = "success";
			}
			status = "failure";
		}
		return status;
	}
}
