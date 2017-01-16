package com.chappal.foot.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.service.UserDetailServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class UserController 
{
	@Autowired
	UserDetailServices userDetailServices;
	
	@RequestMapping("/orderStatus-{userId}")
	public String orderStatus()
	{
		return "/orderhistory";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model,String userName,@ModelAttribute("userDetail") UserDetail userDetail)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		userName = authentication.getName();
		UserDetail newUserDetail = userDetailServices.retriveUserByName(userName);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String userJson = gson.toJson(newUserDetail);
		model.addAttribute("userDetail", new UserDetail());
		model.addAttribute("userList",userJson);
		BillingAddress billingAddress = userDetailServices.retriveBAddressById(newUserDetail.getUserId());
		String billingJson = gson.toJson(billingAddress);
		model.addAttribute("billingAddressList", billingJson);
		ShippingAddress shippingAddress = userDetailServices.retriveSAddressById(newUserDetail.getUserId());
		String shippingJson = gson.toJson(shippingAddress);
		model.addAttribute("shippingAddressList", shippingJson);
		return "/personalinfo";
	}
	
	@RequestMapping("/addImage")
	public String addImage(@ModelAttribute("userDetail") UserDetail userDetail,@PathVariable("userImage") MultipartFile userImage)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		String path = "D:\\WorkSpace\\Projects\\Foot\\src\\main\\webapp\\resources\\images\\user\\";
		path = path + userName + ".jpg";
		File file = new File(path);
		if(file.exists())
		{
			file.delete();
		}
		MultipartFile multipartFile = userDetail.getUserImage();
		if(!multipartFile.isEmpty())
		{
			try 
			{
				byte[] bytes;
				bytes = multipartFile.getBytes();
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				bos.write(bytes);
				bos.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return "redirect:/profile";
	}
}
