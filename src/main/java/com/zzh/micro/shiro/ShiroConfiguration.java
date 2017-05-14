package com.zzh.micro.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfiguration {	
	@Resource
	private MyShiroRealm myShiroRealm;
	
	//thymeleaf中使用shiro标签
	@Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
	
	@Bean
	public SecurityManager  securityManager(){
	    DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
	    defaultWebSecurityManager.setRealm(myShiroRealm);
	    //defaultWebSecurityManager.setCacheManager(ehCacheManager());
	    return defaultWebSecurityManager;
	}
	
    @Bean  
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        System.out.println("ShiroConfiguration.shiroFilter() INTO Configuration");  
        
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean(); 
        shiroFilterFactoryBean.setSecurityManager(securityManager); 
        
//       自定义filter没有使用
//       Map<String,Filter> filterMap = new LinkedHashMap<>();
//       filterMap.put("authc",loginFilter());
//       filterMap.put("perms",myFilter());
//       shiroFilterFactoryBean.setFilters(filterMap);
        
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/main");  
        
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/css/**","anon");
        map.put("/bootstrap/**","anon");
        map.put("/js/**","anon");
        map.put("/user/*","anon");
        map.put("/main","authc");
    	
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
    
    @Bean
    public LoginFilter loginFilter(){
        return new LoginFilter();
    }
    
    @Bean
    public MyFilter myFilter() {
        return new MyFilter();
    }
}
