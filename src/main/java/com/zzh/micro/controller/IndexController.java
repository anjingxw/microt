package com.zzh.micro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzh.micro.entity.User;

@Controller
@RequestMapping("/")
public class IndexController  extends BaseController{
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String index(User model){
		return "login";
	}
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main(User model){
		return "main";
	}
}
