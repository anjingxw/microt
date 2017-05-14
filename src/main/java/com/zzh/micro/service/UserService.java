package com.zzh.micro.service;

import com.zzh.micro.dto.LoginResult;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.User;

public interface UserService {
	/*
	 * 登录
	 */
	Result<LoginResult> login(User user);
}
