package com.chappal.foot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FootController 
{
	@RequestMapping("/")
	public String index()
	{
		return "/index";
	}
	@RequestMapping("/403")
	public String error403()
	{
		return "/403";
	}
}
