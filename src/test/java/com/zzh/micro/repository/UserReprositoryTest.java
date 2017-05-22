package com.zzh.micro.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzh.micro.comm.Const;
import com.zzh.micro.entity.Company;
import com.zzh.micro.entity.CompanyDepartment;
import com.zzh.micro.entity.Role;
import com.zzh.micro.entity.User;
import com.zzh.micro.entity.UserPost;
import com.zzh.micro.entity.UserProperty;
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
	@Autowired
	private UserPropertyReprository userPropertyReprository;
	@Autowired
	private UserPostReprository userPostReprository;
	@Autowired
	private CompanyDepartmentReprository companyDepartmentReprository;
	@Test
	public void test() throws Exception {
		roleReprository.deleteAllInBatch();
		userPropertyReprository.deleteAllInBatch();
		userPostReprository.deleteAllInBatch();
		companyDepartmentReprository.deleteAllInBatch();
		companyReprository.deleteAllInBatch();
		userRepository.deleteAllInBatch();
		
		Company company = new Company();
		company.setCompanyName("测试企业");
		company.setCompanyType(0L);
		company.setCreateTime(DateUtils.getCurrentTime());	
		companyReprository.save(company);
		
		CompanyDepartment department = new CompanyDepartment();
		department.setDepartmentName("A");
		department.setCompany(company);
		companyDepartmentReprository.save(department);
		CompanyDepartment departmentb = new CompanyDepartment();
		departmentb.setDepartmentName("B");
		departmentb.setCompany(company);
		companyDepartmentReprository.save(departmentb);
		
		UserPost userPost= new UserPost();
		userPost.setPostName("科长");
		userPostReprository.save(userPost);
		UserPost userPostb= new UserPost();
		userPostb.setPostName("科员");
		userPostReprository.save(userPostb);
		
		UserProperty userProperty = new UserProperty();
		userProperty.setDisplayName("陈洪飞");
		userProperty.setGender(0);
		userPropertyReprository.save(userProperty);
		
		User user = new User();
		user.setLoginName("admin");
		user.setPassword(MD5Util.encrypt("123456"+Const.PASSWORD_KEY));
		user.setCreateTime(DateUtils.getCurrentTime());
		user.setExpiryDate("2050-0-1");
		user.setCompany(company);
		user.setDepartment(department);
		user.setProperty(userProperty);
		user.setPost(userPost);
		userRepository.save(user);
	
		userProperty = new UserProperty();
		userProperty.setDisplayName("陈洪飞");
		userProperty.setGender(0);
		userPropertyReprository.save(userProperty);
		User userNormal = new User();
		userNormal.setLoginName("normal");
		userNormal.setDepartment(departmentb);
		userNormal.setPassword(MD5Util.encrypt("123456"+Const.PASSWORD_KEY));
		userNormal.setCreateTime(DateUtils.getCurrentTime());
		userNormal.setExpiryDate("2050-0-1");
		userNormal.setCompany(company);
		userNormal.setPost(userPostb);
		userNormal.setProperty(userProperty);
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
