package com.zzh.micro.login;

import org.hamcrest.collection.IsMapContaining;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzh.micro.BaseTest;
import com.zzh.micro.entity.User;
import com.zzh.micro.service.UserService;

public class UserLoginTest extends BaseTest{
	
	@Autowired
	UserService userService;
	
	@Test
	public void testLogin() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/user/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("")
        		.param("loginName", "admin")
                .param("password", "123456"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                // {"code":200,"message":"ok","data":{"content":[{"id":1,"loginname":"admin","name":"admin","password":"098f6bcd4621d373cade4e832627b4f6","sex":0,"age":25,"phone":"18707173376","usertype":0,"status":0,"organizationid":1,"createtime":1449378845000},{"id":13,"loginname":"snoopy","name":"snoopy","password":"098f6bcd4621d373cade4e832627b4f6","sex":0,"age":25,"phone":"18707173376","usertype":1,"status":0,"organizationid":3,"createtime":1443676327000},{"id":14,"loginname":"dreamlu","name":"dreamlu","password":"098f6bcd4621d373cade4e832627b4f6","sex":0,"age":25,"phone":"18707173376","usertype":1,"status":0,"organizationid":5,"createtime":1444576378000},{"id":15,"loginname":"test","name":"test","password":"098f6bcd4621d373cade4e832627b4f6","sex":0,"age":25,"phone":"18707173376","usertype":1,"status":0,"organizationid":6,"createtime":1449378783000}],"last":true,"totalPages":1,"totalElements":4,"number":0,"size":10,"numberOfElements":4,"first":true,"sort":null}}
                .andExpect(MockMvcResultMatchers.jsonPath("success", Is.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("data", IsMapContaining.hasEntry("name","ssssssssss")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
	}
    
}
