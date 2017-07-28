package com.company.service.iservice;

import java.util.List;

import com.company.dao.pojo.Emp;
/**
 * 
 * @author wpjt1
 * Emp 详细信息的Service接口
 */
public interface IEmpService extends IBasicService<Emp, Integer> {
	
	List<Emp> findByName(String pname);// 接口独有功能 根据商品名称进行模糊查询
}
