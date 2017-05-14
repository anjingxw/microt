package com.zzh.micro.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.AuthenticationFilter;

//loginFilter替换原来的authc过滤器
public class LoginFilter extends AuthenticationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//	    HttpServletRequest request = (HttpServletRequest) servletRequest;
//        Subject subject = getSubject(servletRequest,servletResponse);
//        String path = request.getServletPath();
//        System.out.println("path = " + path);
//        if(path.equals("/RPCAFA2A208FA648EA27C1EC30CADFC8B3D"))
//        {
//            return true;
//        }
//        if(subject.getPrincipals() != null)
//        {
//            return true;
//        }
//        return false;
		return super.isAccessAllowed(request, response, mappedValue);
	}
	
	
	//可以自定义返回的数据，比如“会话超时或权限校验未通过的，统一返回401，由前端页面弹窗提示”
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
