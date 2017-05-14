package com.zzh.micro.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.micro.entity.Role;
import com.zzh.micro.entity.User;
import com.zzh.micro.repository.UserReprository;

//权限和登录管理的具体实现
@Service
public class MyShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private UserReprository userReprository;
	

	//doGetAuthorizationInfo权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String loginName = (String)super.getAvailablePrincipal(principalCollection); 
		User user = userReprository.findByLoginName(loginName);
		if (user != null) {
			 SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
			 for(Role role: user.getRoles()){
				 info.addRole(role.getRoleName());
			 }
			 return info;
		}
	    return null;
	}
	
	//doGetAuthenticationInfo登录认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
		User user = userReprository.findByLoginName(token.getUsername());
		if (user != null) {
            return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), this.getName());
        }
		return null;
	}

}
