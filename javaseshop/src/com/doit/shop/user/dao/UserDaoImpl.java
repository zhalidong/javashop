package com.doit.shop.user.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.doit.shop.constant.DataBasePathConstant;
import com.doit.shop.user.bean.User;
import com.doit.shop.utils.FileOperateUtil;

public class UserDaoImpl implements UserDao{
	FileOperateUtil<User> util = new FileOperateUtil<User>();
	@SuppressWarnings("unchecked")
	@Override
	public boolean addUser(User user) throws Exception {
		HashMap<String, User> userMap = null;
		//判断文件是否存在
		File file = new File(DataBasePathConstant.USER_DATA_PATH);
		if (file.exists()) {
		//取出整个user数据库
		userMap=util.readMapFromFile(DataBasePathConstant.USER_DATA_PATH);
		}else {
			userMap = new HashMap<>();
		}
		
		//把新用户添加到usermap中
		userMap.put(user.getAccount(), user);
		
		//把整个usermap数据写入文件中
		util.saveMapToFile(userMap,DataBasePathConstant.USER_DATA_PATH);
		
		return true;
	}

	@Override
	public boolean removeUser(String account) throws Exception {
		//先加载整个user数据库
		HashMap<String, User> userMap = util.readMapFromFile(DataBasePathConstant.USER_DATA_PATH);
		
		User remove = userMap.remove(account);
		if(remove==null){
			return false;
		}
		
		//写入
		util.saveMapToFile(userMap,DataBasePathConstant.USER_DATA_PATH);

		return true;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		//先加载整个user数据库
		HashMap<String, User> userMap = util.readMapFromFile(DataBasePathConstant.USER_DATA_PATH);
		userMap.put(user.getAccount(), user);
		util.saveMapToFile(userMap,DataBasePathConstant.USER_DATA_PATH);

		return true;
	}
	
	@Override
	public User getUserByAccount(String account) throws Exception {
		//取出整个user数据库
		HashMap<String, User> userMap = util.readMapFromFile(DataBasePathConstant.USER_DATA_PATH);
		return userMap.get(account);
	}

	@Override
	public List<User> getUserByAgeRange(int maxAge, int minAge) throws Exception {
		HashMap<String, User> userMap = util.readMapFromFile(DataBasePathConstant.USER_DATA_PATH);
		
		ArrayList<User> arrayList = new ArrayList<>();
		//拿出hashmap中的value
		Collection<User> users = userMap.values();
		
		for(User u:users){
			if (u.getAge()>=minAge && u.getAge()<=maxAge) {
				arrayList.add(u);
			}
		}
		return arrayList;
	}

	@Override
	public List<User> getUserByVipRange(int maxVip, int minVip) throws Exception {
		HashMap<String, User> userMap = util.readMapFromFile(DataBasePathConstant.USER_DATA_PATH);
		ArrayList<User> arrayList = new ArrayList<>();
		Collection<User> users = userMap.values();
		
		for(User u:users){
			if (u.getVipLevel()>=minVip && u.getVipLevel()<=maxVip) {
				arrayList.add(u);
			}
		}
		return arrayList;
	}

	@Override
	public List<User> getUserByName(String name) throws Exception {
		HashMap<String, User> userMap = util.readMapFromFile(DataBasePathConstant.USER_DATA_PATH);
		ArrayList<User> arrayList = new ArrayList<>();
		Collection<User> users = userMap.values();
		
		for(User u:users){
			if (u.getName().contains(name)) {
				arrayList.add(u);
			}
		}
		return arrayList;
	}

}
