package com.zzh.micro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzh.micro.comm.Const;
import com.zzh.micro.entity.User;

@Controller
@RequestMapping("/")
public class IndexController  extends BaseController{
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String index(User model){
		return "login";
	}
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main(Model model){
		model.addAttribute("userInfo", getSession().getAttribute(Const.LOGIN_SESSION_KEY));
		return "main";
	}
	
	@RequestMapping(value="/changepwd",method=RequestMethod.GET)
	public String changepwd(){
		return "fragment/user :: changepwd";
	}
}
