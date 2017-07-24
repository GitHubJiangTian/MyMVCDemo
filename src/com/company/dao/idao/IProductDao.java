package com.company.dao.idao;

import java.util.List;

import com.company.dao.pojo.Product;

public interface IProductDao extends IBasicDao<Product, Integer> {
	List<Product> findByName(String pname) throws Exception;
	
	List<Product> findByPage(int page,int size) throws Exception;
}
