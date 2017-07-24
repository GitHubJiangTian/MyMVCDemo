package com.company.dao.idao;

import java.util.List;

public interface IBasicDao<T,K> {
	/**
	 * 增加
	 * @param t
	 */
	void save(T t) throws Exception;
	/**
	 * 修改
	 * @param t
	 */
	void update(T t) throws Exception;
	/**
	 * 删除
	 * @param t
	 */
	void delete(T t) throws Exception;
	/**
	 * 查找所有
	 * @return List
	 * 返回所有符合条件的实例的集合
	 */
	List<T> findAll() throws Exception;
	/**
	 * 
	 * @param k id
	 * @return T 此id的对象
	 * 返回id为k的对象实例
	 */
	T findById(K k) throws Exception;
}
