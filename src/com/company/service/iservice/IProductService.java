package com.company.service.iservice;

import java.util.List;

import com.company.dao.pojo.Product;
/**
 * 
 * @author wpjt1
 * 产品详细信息的Service接口
 */
public interface IProductService extends IBasicService<Product, Integer> {
	
	List<Product> findByName(String pname);// 接口独有功能 根据商品名称进行模糊查询
}
