package com.company.service.iservice;

import java.util.List;

/**
 * 
 * @author wpjt1
 * 将通用功能抽象出来的接口，基础接口
 * @param <T> Orders  Item   Product  Detail Login
 * @param <K> findById(Integer k)   K指代表的主键数据类型
 */
public interface IBasicService<T,K> {
	/**
	 * 增加
	 * @param t
	 * @return String
	 */
	String save(T t);
	/**
	 * 修改
	 * @param t
	 * @return String
	 */
	String update(T t);
	/**
	 * 删除
	 * @param t
	 * @return String
	 */
	String delete(T t);
	/**
	 * 查找所有
	 * @return List
	 * 返回所有符合条件的实例的集合
	 */
	List<T> findAll();
	/**
	 * 
	 * @param k id
	 * @return T 此id的对象
	 * 返回id为k的对象实例
	 */
	T findById(K k);
}
