package com.chappal.foot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController 
{
	@RequestMapping("/adminPanel")
	public String adminPanel()
	{
		return "/adminPanel";
	}
}
