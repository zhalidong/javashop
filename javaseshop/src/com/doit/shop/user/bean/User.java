package com.doit.shop.user.bean;

import java.io.Serializable;
/**
 * 描述用户数据的实体类
 * @author Administrator
 *
 */
public class User implements Serializable{
	private String account;		//账号
	private String password;	
	private int age;
	private int vipLevel;
	private String phone;
	private String addr;
	private String name;
	
	
	
	
	
	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", age=" + age + ", vipLevel=" + vipLevel
				+ ", phone=" + phone + ", addr=" + addr + ", name=" + name + "]";
	}
	
	public User(){}
	
	public void Set(String account, String password, int age, int vipLevel, String phone, String addr, String name) {
		this.account = account;
		this.password = password;
		this.age = age;
		this.vipLevel = vipLevel;
		this.phone = phone;
		this.addr = addr;
		this.name = name;
	}
	
	
	public User(String account, String password, int age, int vipLevel, String phone, String addr, String name) {
		super();
		this.account = account;
		this.password = password;
		this.age = age;
		this.vipLevel = vipLevel;
		this.phone = phone;
		this.addr = addr;
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
