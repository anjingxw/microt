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
import com.zzh.micro.dto.LoginResult;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.User;
import com.zzh.micro.service.UserService;
import com.zzh.micro.util.MD5Util;

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
	 public Result<LoginResult> login(User user, HttpServletRequest request, HttpServletResponse response) {
	       logger.info("request: user/login , user: " + user.toString());
	       Result<LoginResult> resultUser = userService.login(user);
	       if (resultUser.isSuccess()) {
	    	   LoginResult loginUser = resultUser.getData();
	           HttpSession session = request.getSession();
	           session.setAttribute(Const.LOGIN_SESSION_KEY, loginUser);
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
	    @RequestMapping("/modifyPassword")
	    @ResponseBody
	    public Result<Boolean> modifyPassword(User user, HttpServletResponse response) throws Exception {
	        String MD5pwd = MD5Util.encrypt((user.getPassword()+Const.PASSWORD_KEY));
	        user.setPassword(MD5pwd);
	        //int resultTotal = userService.updateUser(user);
	        //logger.info("request: user/modifyPassword , user: " + user.toString());
//	        if (resultTotal > 0) {
//	           return new Result<Boolean>(true, true);
//	        } else 
	        {
	           return new Result<Boolean>(true, false);
	        }
	   }
	 
	    /**
	     *
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) throws Exception {
	        session.invalidate();
	        logger.info("request: user/logout");
	        return "redirect:/login.jsp";
	    }
}