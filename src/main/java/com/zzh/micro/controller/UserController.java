package com.zzh.micro.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzh.micro.comm.Const;
import com.zzh.micro.dto.UserInfo;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.User;
import com.zzh.micro.service.UserService;

/**
 * 
 * @author anjingxw
 *
 */

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @Autowired
	 private UserService userService;

	 /**
	  * @param user
	  * @param request
	  * @return
	  */
	 @RequestMapping("/login")
	 @ResponseBody
	 public Result<UserInfo> login(User user, HttpServletRequest request, HttpServletResponse response) {
	       logger.info("request: user/login , user: " + user.toString());
	       Result<UserInfo> resultUser = userService.login(user);
	       if (resultUser.isSuccess()) {
	    	   UserInfo loginUser = resultUser.getData();
	           getSession().setAttribute(Const.LOGIN_SESSION_KEY, loginUser);
	    	   String flag = request.getParameter("flag"); 
	    	   if(flag!=null){ 
	    		    Cookie cookie = new Cookie("cookie_user", cookieSign(loginUser.getLoginName())); 
	    		    cookie.setMaxAge(Const.COOKIE_TIMEOUT);// 保存 
	    		    response.addCookie(cookie); 
	    		    logger.info("存储用户的cookie:"+cookieSign(loginUser.getLoginName())); 
	    	   }
	       } 
	       return resultUser;
	 }
	 
	   /**
	     * @param user
	     * @param response
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping("/changepwd")
	    @ResponseBody
	    public Result<String> changepwd(String oldPwd, String newPwd, HttpServletResponse response) throws Exception {
	    	return userService.changePwd(oldPwd, newPwd);
	   }
	 
	    /**
	     *
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping("/logout")
		@ResponseBody
	    public  Result<String> logout(HttpServletResponse response) throws Exception {
	    	response.setHeader("Pragma","No-cache");  
	    	response.setHeader("Cache-Control","No-cache");  
	    	response.setDateHeader("Expires", -1);  
	    	response.setHeader("Cache-Control", "No-store"); 
	    	return userService.logout();
	    }
	    

}