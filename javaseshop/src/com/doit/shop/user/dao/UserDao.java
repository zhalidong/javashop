package com.doit.shop.user.dao;

import java.util.List;

import com.doit.shop.user.bean.User;

public interface UserDao {

	//增加一个用户
	public boolean addUser(User user)throws Exception;
	//删除一个用户
	public boolean removeUser(String account)throws Exception;
	
	//修改用户 ，要求service层把要修改的用户的所有数据全传过来
	public boolean updateUser(User user) throws Exception;
	//根据账号查询用户
	public User getUserByAccount(String account)throws Exception;
	//根据年龄范围查询用户
	public List<User> getUserByAgeRange(int maxAge,int minAge) throws Exception;
	//根据vip等级查询用户
	public List<User> getUserByVipRange(int maxVip,int minVip) throws Exception;
	//根据姓名 查询用户
	public List<User> getUserByName(String name) throws Exception;
	
	
}
