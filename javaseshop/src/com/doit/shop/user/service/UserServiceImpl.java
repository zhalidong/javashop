package com.doit.shop.user.service;

import com.doit.shop.user.bean.User;
import com.doit.shop.user.dao.UserDao;
import com.doit.shop.user.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean checkIfAccountExist(String account) throws Exception {
		User user = userDao.getUserByAccount(account);
		return user!=null;
	}

	@Override
	public boolean addUser(User user) throws Exception {
		boolean addUser = userDao.addUser(user);
		return addUser;
	}

	@Override
	public boolean userLogin(String account, String password) throws Exception {
		User user = userDao.getUserByAccount(account);
		if(user==null){
			return false;
		}else {
			return user.getPassword().equals(password);
		}
	}

	@Override
	public boolean updateUserName(String account, String newName) throws Exception {
		User user = userDao.getUserByAccount(account);
		if(user==null){
			return false;
		}
		user.setName(newName);
		userDao.updateUser(user);
		
		return true;
	}

	@Override
	public boolean updateUserAge(String account, int newAge) throws Exception{
		User user = userDao.getUserByAccount(account);
		if(user==null){
			return false;
		}
		user.setAge(newAge);
		userDao.updateUser(user);
		return false;
	}

	@Override
	public boolean removeUser(String account) throws Exception{
		boolean removeUser = userDao.removeUser(account);
		return removeUser;
	}
	
}
