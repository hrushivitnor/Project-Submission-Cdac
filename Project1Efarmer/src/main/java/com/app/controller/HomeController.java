package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
 public HomeController()
 {
	 System.out.println("in cnstr of"+getClass().getName());
 }
@RequestMapping("/")
public String   showWelcomePage() 
{
	System.out.println("in show welcome page");
	return "/index";
  }

}
