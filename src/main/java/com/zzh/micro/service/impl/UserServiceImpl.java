package com.zzh.micro.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.micro.comm.Const;
import com.zzh.micro.dto.LoginResult;
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
	public Result<LoginResult> login(User _user) {
		try{
			UsernamePasswordToken token = new UsernamePasswordToken(_user.getLoginName(),  MD5Util.encrypt(_user.getPassword() + Const.PASSWORD_KEY));
			token.setRememberMe(true);
			SecurityUtils.getSubject().login(token); 
		} catch ( UnknownAccountException uae ) {
			return new Result<>(false, "用户不存在");
		} catch ( IncorrectCredentialsException ice ) {
			UpdateLoginErrorInfo(_user.getLoginName());
			return new Result<>(false, "密码错误");
		} catch (LockedAccountException lae ) {
			return new Result<>(false, "账户被锁定");
		}
		catch (Exception e) {
		}
 
		UpdateLoginInfo(_user.getLoginName());
		User user = userReprository.findByLoginName(_user.getLoginName());
		LoginResult  result = new LoginResult(user.getUserID(), user.getLoginName(), user.getAppLoginToken());
		return new Result<LoginResult>(true, result); 
	}

	//	
	private void UpdateLoginErrorInfo(String loginName){
	}
	
	private void UpdateLoginInfo(String loginName){
		
	}
}
