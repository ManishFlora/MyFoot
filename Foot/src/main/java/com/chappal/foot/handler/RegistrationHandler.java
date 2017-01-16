package com.chappal.foot.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.Supplier;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.service.SupplierServices;
import com.chappal.foot.service.UserDetailServices;

@Component
public class RegistrationHandler 
{
	@Autowired
	UserDetailServices userDetailServices;
	
	@Autowired
	BillingAddress billingAddress;
	
	@Autowired
	ShippingAddress shippingAddress;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierServices supplierServices;
	
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
			status= "success";
		}
		
		if(userDetail.getLastName().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("lastName").defaultText("Field cant be Empty").build());
			status= "failure";
		}
		else
		{
			status= "success";
		}
		
		if(userDetail.getEmailId().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("emailId").defaultText("Field cant be Empty").build());
			status= "failure";
		}
		else
		{
			status= "success";
		}
		
		if(userDetail.getContactNumber().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("contactNumber").defaultText("Field cant be Empty").build());
			status= "failure";
		}
		else
		{
			status= "success";
		}
		
		return status;
	}
	
	public String checkUser(UserDetail userDetail,MessageContext message)
	{
		String status;
		int count = userDetailServices.checkUser(userDetail.getUserName());
		if(count == 1)
		{
			message.addMessage(new MessageBuilder().error().source("userName").defaultText("User already exsist.").build());
			status = "failure";
		}
		else
		{
			status = "success";
		}
		return status;
	}
	
	public String checkEmail(UserDetail userDetail,MessageContext message)
	{
		String status = "success";
		int count = userDetailServices.checkEmail(userDetail.getEmailId());
		if(count == 1)
		{
			message.addMessage(new MessageBuilder().error().source("emailId").defaultText("Email already exsist.").build());
			status = "failure";
		}
		else
		{
			status = "success";
		}
		return status;
	}
	
	public void addBillingAddress(BillingAddress billingAddress)
	{
			this.billingAddress.setCity(billingAddress.getCity());
			this.billingAddress.setCountry(billingAddress.getCountry());
			this.billingAddress.setFlatNumber(billingAddress.getFlatNumber());
			this.billingAddress.setState(billingAddress.getState());
			this.billingAddress.setStreetAddress(billingAddress.getStreetAddress());
			this.billingAddress.setZipCode(billingAddress.getZipCode());
	}
	
	public void addShippingAddress(ShippingAddress shippingAddress)
	{
			this.shippingAddress.setCity(shippingAddress.getCity());
			this.shippingAddress.setCountry(shippingAddress.getCountry());
			this.shippingAddress.setFlatNumber(shippingAddress.getFlatNumber());
			this.shippingAddress.setState(shippingAddress.getState());
			this.shippingAddress.setStreetAddress(shippingAddress.getStreetAddress());
			this.shippingAddress.setZipCode(shippingAddress.getZipCode());
	}
	
	public void addUserData(UserDetail userDetail, ShippingAddress shippingAddress,BillingAddress billingAddress)
	{
		shippingAddress.setUserDetail(userDetail);
		userDetail.setShippingAddress(shippingAddress);
		this.shippingAddress.setUserDetail(userDetail);
		
		billingAddress.setUserDetail(userDetail);
		userDetail.setBillingAddress(billingAddress);
		this.billingAddress.setUserDetail(userDetail);
		
		userDetail.setBillingAddress(billingAddress);
		userDetail.setShippingAddress(shippingAddress);
		userDetail.setUserId(userDetailServices.generatedId());
		userDetailServices.addUserRegDetail(userDetail);
	}
	
	public String validateSupplier(Supplier supplier, MessageContext message)
	{
		String status = "success";
		
		if(supplier.getSupplierName().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("supplierName").defaultText("Field cant be Empty").build());
			status = "failure";
		}
		else
		{
			status = "success";
		}
		
		if(supplier.getSupplierAddress().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("supplierAddress").defaultText("Field cant be Empty").build());
			status = "failure";
		}
		else
		{
			status = "success";
		}
		
		if(supplier.getSupplierEmailId().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("supplierEmailId").defaultText("Field cant be Empty").build());
			status= "failure";
		}
		else
		{
			status= "success";
		}
		
		if(supplier.getSupplierPhoneNumber().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("supplierPhoneNumber").defaultText("Field cant be Empty").build());
			status= "failure";
		}
		else
		{
			status= "success";
		}		
		return status;
	}
	
	public void addSupplierData(Supplier supplier)
	{
		this.supplier.setSupplierName(supplier.getSupplierName());
		this.supplier.setSupplierEmailId(supplier.getSupplierEmailId());
		this.supplier.setSupplierAddress(supplier.getSupplierAddress());
		this.supplier.setSupplierPhoneNumber(supplier.getSupplierPhoneNumber());
	}
	
	public void saveSupplier(Supplier supplier,UserDetail userDetail)
	{
		userDetail.setUserId(userDetailServices.generatedId());
		this.supplierServices.addRegSupplier(userDetail);
		supplier.setUserDetail(userDetail);
		userDetail.setSupplier(supplier);
		this.supplier.setUserDetail(userDetail);
		supplier.setSupplierId(supplierServices.generateId());
		supplier.setUserDetail(userDetail);
		supplierServices.addSupplier(supplier);
	}
}