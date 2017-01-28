package com.chappal.foot.handler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.Category;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.Supplier;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.service.BrandServices;
import com.chappal.foot.service.CategoryServices;
import com.chappal.foot.service.SupplierServices;
import com.chappal.foot.service.UserDetailServices;

@Component
public class RegistrationHandler 
{
	@Autowired
	CategoryServices categoryServices;
	
	@Autowired
	BrandServices brandServices;
	
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
	
	public ModelAndView dataBinding()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("categoryList", categoryServices.retriveCategory());
		model.addObject("brandList", brandServices.retriveBrand());
		model.setViewName("reg");
		return model;
	}
	
	public String validateUser(UserDetail userDetail, MessageContext message)
	{
		String status = "success";
		
		if(userDetail.getUserName().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("userName").defaultText("Field cant be Empty").build());
			return "failure";
		}
		else
		{
			status = "success";
		}
		
		if(userDetail.getUserPassword().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("userPassword").defaultText("Field cant be Empty").build());
			return "failure";
		}
		else if(userDetail.getUserPassword().matches("(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,10})$"))
		{
			status = "success";
		}
		else
		{
			message.addMessage(new MessageBuilder().error().source("userPassword").defaultText("Invalid Pattern").build());
			return "failure";
		}
		
		if(userDetail.getFirstName().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("firstName").defaultText("Field cant be Empty").build());
			return  "failure";
		}
		else
		{
			status= "success";
		}
		
		if(userDetail.getLastName().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("lastName").defaultText("Field cant be Empty").build());
			return  "failure";
		}
		else
		{
			status= "success";
		}
		
		if(userDetail.getEmailId().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("emailId").defaultText("Field cant be Empty").build());
			return  "failure";
		}
		else
		{
			status= "success";
		}
		
		if(userDetail.getContactNumber().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("contactNumber").defaultText("Field cant be Empty").build());
			return  "failure";
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
			return "failure";
		}
		else
		{
			status = "success";
		}
		
		count = userDetailServices.checkEmail(userDetail.getEmailId());
		if(count == 1)
		{
			message.addMessage(new MessageBuilder().error().source("emailId").defaultText("Email already exsist.").build());
			return "failure";
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
		try 
		{
			String p = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\user\\user.jpg";
			File file = new File(p);
			String userName = userDetail.getUserName();
			BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(file);
			p = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\user\\"+ userName + ".jpg";
			file = new File(p);
			BufferedImage bufferedImage = image;
			ImageIO.write(bufferedImage, "jpg", file);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String validateSupplier(Supplier supplier, MessageContext message)
	{
		String status = "success";
		if(supplier.getSupplierAddress().isEmpty())
		{
			message.addMessage(new MessageBuilder().error().source("supplierAddress").defaultText("Field cant be Empty").build());
			status = "failure";
		}
		else
		{
			status = "success";
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
		supplier.setSupplierEmailId(userDetail.getEmailId());
		supplier.setSupplierName(userDetail.getFirstName()+ " " + userDetail.getLastName());
		supplier.setSupplierPhoneNumber(userDetail.getContactNumber());
		supplierServices.addSupplier(supplier);
		try 
		{
			String p = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\user\\supplier.png";
			File file = new File(p);
			String userName = userDetail.getUserName();
			BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(file);
			p = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\user\\"+ userName + ".png";
			file = new File(p);
			BufferedImage bufferedImage = image;
			ImageIO.write(bufferedImage, "png", file);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}