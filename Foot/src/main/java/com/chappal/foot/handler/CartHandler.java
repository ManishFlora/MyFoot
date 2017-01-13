package com.chappal.foot.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.BuyNow;
import com.chappal.foot.model.ShippingAddress;

@Component
public class CartHandler 
{
	@Autowired
	ShippingAddress shippingAddress;
	
	@Autowired
	BillingAddress billingAddress;
	
	public BuyNow initFlow()
	{
		return new BuyNow();
	}
	
	public String validateShipping(ShippingAddress shippingAddress,MessageContext message)
	{
		String status = "success";
		if(shippingAddress.getCity().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("city").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(shippingAddress.getCountry().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("country").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(shippingAddress.getFlatNumber().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("flatNumber").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(shippingAddress.getState().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("state").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(shippingAddress.getStreetAddress().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("streetAddress").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(shippingAddress.getZipCode().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("zipCode").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		return status;
	}
	
	public String validateBilling(BillingAddress billingAddress,MessageContext message)
	{
		String status = "success";
		if(billingAddress.getCity().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("city").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(billingAddress.getCountry().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("country").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(billingAddress.getFlatNumber().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("flatNumber").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(billingAddress.getState().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("state").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(billingAddress.getStreetAddress().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("streetAddress").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		if(billingAddress.getZipCode().isEmpty())
		{
			status = "failure";
			message.addMessage(new MessageBuilder().error().source("zipCode").defaultText("Field cant be Empty").build());
		}
		else
		{
			status = "success";
		}
		return status;
	}
}
