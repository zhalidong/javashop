package com.doit.shop.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.doit.shop.constant.DataBasePathConstant;
import com.doit.shop.user.bean.User;

public class FileOperateUtil<T> {
	public  HashMap<String, T> readMapFromFile(String path) throws Exception{
		ObjectInputStream bis = new ObjectInputStream(new FileInputStream(path));
		HashMap<String, T> userMap = (HashMap<String, T>) bis.readObject();
		bis.close();
		return userMap;
	}
	
	public  void saveMapToFile(HashMap<String, T> usermap,String path)throws Exception{
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(usermap);
		oos.close();
		
		
	}
	
	
}
