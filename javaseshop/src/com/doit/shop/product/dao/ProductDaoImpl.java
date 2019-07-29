package com.doit.shop.product.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.rmi.CORBA.Util;

import com.doit.shop.constant.DataBasePathConstant;
import com.doit.shop.product.pojo.Product;
import com.doit.shop.user.bean.User;
import com.doit.shop.utils.FileOperateUtil;

public class ProductDaoImpl implements ProductDao{
	FileOperateUtil<Product> util = new FileOperateUtil<>();

	@Override
	public List<Product> getAllProducts() throws Exception {
		// 先从数据库加载数据
		HashMap<String, Product> pMap = util.readMapFromFile(DataBasePathConstant.PRODUCT_DATA_PATH);
		Collection<Product> pdts = pMap.values();
		ArrayList<Product> pList = new ArrayList<>();
		
		for(Product p:pdts) {
			pList.add(p);
		}
		
		return pList;
	}

	@Override
	public List<Product> getProductsByCateName(String cateName) throws Exception {
		
		// 先从数据库加载数据
		HashMap<String, Product> pMap = util.readMapFromFile(DataBasePathConstant.PRODUCT_DATA_PATH);
		Collection<Product> pdts = pMap.values();
		ArrayList<Product> pList = new ArrayList<>();
		
		// 将符合条件的商品放入pList
		for(Product p:pdts) {
			if(p.getCategoryName().contains(cateName)) {
				pList.add(p);
			}
		}
		
		return pList;
	}

	@Override
	public List<Product> getProductsByPriceRange(float min, float max) throws Exception {
		// 先从数据库加载数据
		HashMap<String, Product> pMap = util.readMapFromFile(DataBasePathConstant.PRODUCT_DATA_PATH);
		Collection<Product> pdts = pMap.values();
		ArrayList<Product> pList = new ArrayList<>();
		
		// 将符合条件的商品放入pList
		for(Product p:pdts) {
			if(p.getPrice()>=min && p.getPrice() <=max) {
				pList.add(p);
			}
		}
		
		return pList;
	}

	
	@Override
	public Product getProductsById(String pId) throws Exception {
		// 先从数据库加载数据
		HashMap<String, Product> pMap = util.readMapFromFile(DataBasePathConstant.PRODUCT_DATA_PATH);
	
		return pMap.get(pId);
	}

	
	
	@Override
	public boolean addProduct(Product product) throws Exception {
		
		// 先从数据库加载数据
		HashMap<String, Product> pMap = util.readMapFromFile(DataBasePathConstant.PRODUCT_DATA_PATH);
	
		pMap.put(product.getpId(), product);

		// 然后将商品map数据重写写入文件
		util.saveMapToFile(pMap, DataBasePathConstant.PRODUCT_DATA_PATH);
		
		
		return true;
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
		
		// 先从数据库加载数据
		HashMap<String, Product> pMap = util.readMapFromFile(DataBasePathConstant.PRODUCT_DATA_PATH);
	
		// 覆盖原来的id中的商品
		pMap.put(product.getpId(), product);

		// 然后将商品map数据重写写入文件
		util.saveMapToFile(pMap, DataBasePathConstant.PRODUCT_DATA_PATH);
		
		
		return true;
	}
}
