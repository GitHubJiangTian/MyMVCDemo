package com.company.dao.idao;

import java.util.List;

import com.company.dao.pojo.Emp;

public interface IEmpDao extends IBasicDao<Emp, Integer> {
	List<Emp> findByName(String pname) throws Exception;
	
	List<Emp> findByPage(int page,int size) throws Exception;
}
