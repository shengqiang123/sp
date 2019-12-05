package com.topscit.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	//调试
	@RequestMapping("/test")
	public String test(String name)
	{
		System.out.println(name);
		return "redirect:/a.jsp";
	}

	
}
