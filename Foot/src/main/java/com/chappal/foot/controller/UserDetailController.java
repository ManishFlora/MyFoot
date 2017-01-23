package com.chappal.foot.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chappal.foot.model.BillingAddress;
import com.chappal.foot.model.ShippingAddress;
import com.chappal.foot.model.User;
import com.chappal.foot.model.UserDetail;
import com.chappal.foot.service.UserDetailServices;

@Controller
public class UserDetailController 
{
	@Autowired
	UserDetailServices userDetailServices;
	
	@RequestMapping("/registrationform")
	public String registration(Model model)
	{
		UserDetail userDetail = new UserDetail();
		ShippingAddress shippingAddress = new ShippingAddress();
		BillingAddress billingAddress = new BillingAddress();
		userDetail.setBillingAddress(billingAddress);
		userDetail.setShippingAddress(shippingAddress);
		model.addAttribute("userDetail" , userDetail);
		return "/registrationform";
	}
	
	@RequestMapping("/addUser")
	public String addUser(Model model, @Valid @ModelAttribute("userDetail") UserDetail userDetail, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "/registrationform";
		}
		else
		{
			userDetail.setUserId(userDetailServices.generatedId());
			userDetailServices.addUserDetail(userDetail);
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
			return "redirect:/registrationform";
		}
	}
	@RequestMapping("/login")
	public String login()
	{
		return "/login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null)
		{
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/home";
	}
}