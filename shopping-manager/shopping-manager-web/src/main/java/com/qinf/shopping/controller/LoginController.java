package com.qinf.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String Login(){
		return "login";
	}
	
	@RequestMapping("/index")
	public String ShowIndex(){
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String ShowPage(@PathVariable String page){
		return page;
	}
}
