package com.doit.shop.user.test;

import java.util.List;

import org.junit.Test;

import com.doit.shop.constant.userVipLevelConstant;
import com.doit.shop.user.bean.User;
import com.doit.shop.user.dao.UserDaoImpl;




public class DaoTest {
	
	@Test
	public void testAddUser() throws Exception{
		User u1 = new User("lovebaby1", "123", 23, userVipLevelConstant.VIP_1, "138888888", "北京", "杨毅");
		User u2 = new User("lovebaby2", "123", 24, userVipLevelConstant.VIP_1, "138888888", "北京", "杨毅");
		User u3 = new User("lovebaby3", "123", 33, userVipLevelConstant.VIP_1, "138888888", "北京", "杨毅");
		User u4 = new User("lovebaby4", "123", 16, userVipLevelConstant.VIP_1, "138888888", "北京", "杨毅");
		User u5 = new User("lovebaby5", "123", 14, userVipLevelConstant.VIP_1, "138888888", "北京", "杨毅");
		
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.addUser(u1);
		userDaoImpl.addUser(u2);
		userDaoImpl.addUser(u3);
		userDaoImpl.addUser(u4);
		userDaoImpl.addUser(u5);
		
		
		User u = userDaoImpl.getUserByAccount("lovebaby");
		System.out.println(u);
		
	}
	@Test
	public void testgetbyage() throws Exception{
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<User> userlist = userDaoImpl.getUserByAgeRange(33, 23);
		System.out.println(userlist);
	}
	
}
