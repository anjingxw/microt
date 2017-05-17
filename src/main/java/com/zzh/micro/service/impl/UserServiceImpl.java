package com.zzh.micro.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.micro.comm.Const;
import com.zzh.micro.dto.UserInfo;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.User;
import com.zzh.micro.repository.UserReprository;
import com.zzh.micro.service.UserService;
import com.zzh.micro.util.MD5Util;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserReprository userReprository;
 
	@Override
	public Result<UserInfo> login(User _user) {
		try{
			UsernamePasswordToken token = new UsernamePasswordToken(_user.getLoginName(),  MD5Util.encrypt(_user.getPassword() + Const.PASSWORD_KEY));
			token.setRememberMe(true);
			SecurityUtils.getSubject().login(token); 
		} catch ( UnknownAccountException uae ) {
			return new Result<>("用户不存在");
		} catch ( IncorrectCredentialsException ice ) {
//			UpdateLoginErrorInfo(_user.getLoginName());
			return new Result<>("密码错误");
		} catch (LockedAccountException lae ) {
			return new Result<>("账户被锁定");
		}
		catch (Exception e) {
		}
 
		UpdateLoginInfo(_user.getLoginName());
		User user = userReprository.findByLoginName(_user.getLoginName());
		UserInfo  result = new UserInfo(user.getUserID()
				, user.getLoginName()
				, user.getDisplayName()
				, user.getAvatars()
				, 80L
				, user.getAppLoginToken());
		return new Result<UserInfo>(true, result); 
	}

	@Override
	public Result<String>  logout(){
		SecurityUtils.getSubject().logout();
		return new Result<String>(true, "login");
	}
	
	/**
	 * 修改密码
	 */
	public Result<String>  changePwd(String old, String newPwd){
		UserInfo info = (UserInfo)SecurityUtils.getSubject().getSession().getAttribute(Const.LOGIN_SESSION_KEY);
		User user = userReprository.findByUserID(info.getUserID());
		if (!MD5Util.encrypt(old + Const.PASSWORD_KEY).equals(user.getPassword())) {
			return new Result<>("原密码错误");
		}
		
		user.setPassword(MD5Util.encrypt(newPwd + Const.PASSWORD_KEY));
		SecurityUtils.getSubject().logout();
		return new Result<String>(true, "login");
	}
	
//	//	
//	private void UpdateLoginErrorInfo(String loginName){
//	}
//	
	private void UpdateLoginInfo(String loginName){
		
	}
}
