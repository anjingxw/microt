package com.zzh.micro.service;

import com.zzh.micro.dto.UserInfo;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.User;
import com.zzh.micro.entity.UserProperty;

public interface UserService {
	/*
	 * 登录
	 */
	Result<UserInfo> login(User user);
	
	/**
	 * 登出
	 */
	Result<String>  logout();
	
	/**
	 * 修改密码
	 */
	Result<String>  changePwd(String old, String newPwd);
	Result<Boolean> updateUserProperty(UserProperty property);
	
	Result<Boolean> addUser(User user);
	Result<Boolean> updateUser(User user);
	Result<Boolean> resetPwd(Long userId);
}
