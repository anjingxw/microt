package com.zzh.micro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zzh.micro.comm.Const;
import com.zzh.micro.entity.User;
import com.zzh.micro.repository.UserReprository;
import com.zzh.micro.util.Des3EncryptionUtil;

public class BaseController {

	@Autowired
	UserReprository userReprository;
	
    protected Logger logger = Logger.getLogger(this.getClass());
    
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    
    protected Session  getSession() {
    	Subject currentUser = SecurityUtils.getSubject();
    	return currentUser.getSession();
    }
    
    protected String getUserIp() {
        String value = getRequest().getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(value) && !"unknown".equalsIgnoreCase(value)) {
            return value;
        } else {
            return getRequest().getRemoteAddr();
        }
    }
    


    protected String cookieSign(String value){
        try{
            value = value + Const.PASSWORD_KEY;
            String sign = Des3EncryptionUtil.encode(Const.DES3_KEY,value);
            return sign;
        }catch (Exception e){
            logger.error("cookie签名异常：",e);
        }
        return null;
    }
}
