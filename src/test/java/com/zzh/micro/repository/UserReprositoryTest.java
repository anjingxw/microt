package com.zzh.micro.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzh.micro.comm.Const;
import com.zzh.micro.entity.Company;
import com.zzh.micro.entity.Role;
import com.zzh.micro.entity.User;
import com.zzh.micro.util.DateUtils;
import com.zzh.micro.util.MD5Util;
;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserReprositoryTest {
	@Autowired
	private UserReprository userRepository;
	@Autowired
	private CompanyReprository companyReprository;
	@Autowired
	RoleReprository roleReprository;
	
	@Test
	public void test() throws Exception {
		userRepository.deleteAll();
		companyReprository.deleteAll();
		roleReprository.deleteAll();
		
		Company company = new Company();
		company.setCompanyName("测试企业");
		company.setCompanyType(0L);
		company.setCreateTime(DateUtils.getCurrentTime());	
		companyReprository.save(company);
		
		User user = new User();
		user.setLoginName("admin");
		user.setPassword(MD5Util.encrypt("123456"+Const.PASSWORD_KEY));
		user.setCreateTime(DateUtils.getCurrentTime());
		user.setExpiryDate("2050-0-1");
		user.setCompany(company);
		userRepository.save(user);
		
		
		User userNormal = new User();
		userNormal.setLoginName("normal");
		userNormal.setPassword(MD5Util.encrypt("123456"+Const.PASSWORD_KEY));
		userNormal.setCreateTime(DateUtils.getCurrentTime());
		userNormal.setExpiryDate("2050-0-1");
		userNormal.setCompany(company);
		userRepository.save(userNormal);
		
		
	    Role role = new Role();
	    role.setRoleName("admin");
	    roleReprository.save(role);
	    user.getRoles().add(role);
	    userRepository.save(user);
//		
//		List<Company> list =  companyReprository.findAll();
//		Company company = list.get(0);
//		List<User> list1 = company.getUsers();
//		int test = list1.size();
//	    assertTrue(test == 1);
	    

	    
	}
}
