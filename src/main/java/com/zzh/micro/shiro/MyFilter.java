package com.zzh.micro.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

//perms过滤器
public class MyFilter extends PermissionsAuthorizationFilter {
	 @Override
	    public boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws IOException {
//	        HttpServletRequest request = (HttpServletRequest) servletRequest;
//
//	        String path = request.getServletPath();
//	        System.out.println("request path = " + path);
//	        Subject subject = getSubject(servletRequest,servletResponse);
//	        if(path.equals("/RPCAFA2A208FA648EA27C1EC30CADFC8B3D"))
//	        {
//	            return true;
//	        }
	       /* String[] perms = (String[])((String[])o);
	        boolean isPermitted = true;
	        if(perms != null && perms.length > 0) {
	            if(perms.length == 1) {
	                if(!subject.isPermitted(perms[0])) {
	                    isPermitted = false;
	                }
	            } else if(!subject.isPermittedAll(perms)) {
	                isPermitted = false;
	            }
	        }*/

	        return super.isAccessAllowed(servletRequest,servletResponse,o);
	    }
	    /**
	     * 会话超时或权限校验未通过的，统一返回401，由前端页面弹窗提示
	     */
	    @Override
	    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
	            throws IOException {
	        System.out.println("no permission");
//	        Subject subject = getSubject(request, response);
//	        if(subject.getPrincipal() == null)
//	        {
//	            ShiroUtil.writeResponse((HttpServletResponse) response,new Result(AuthorizationStatus.NOT_LOGIN));
//	        }else{
//	            ShiroUtil.writeResponse((HttpServletResponse) response,new Result(AuthorizationStatus.NOT_AUTHORIZATION));
//	        }
	        return false;
	    }
}
