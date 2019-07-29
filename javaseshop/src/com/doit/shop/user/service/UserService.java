package com.doit.shop.user.service;

import com.doit.shop.user.bean.User;

public interface UserService {
	//检查要注册的账户是否已存在
	public boolean checkIfAccountExist(String account) throws Exception;
	//添加用户到数据库
	public boolean addUser(User user) throws Exception;
	//
	public boolean userLogin(String account,String password) throws Exception;
	
	public boolean updateUserName(String account,String newName) throws Exception;
	
	public boolean updateUserAge(String account,int newAge) throws Exception;
	//注销账号
	public boolean removeUser(String account) throws Exception;
	
	
}
