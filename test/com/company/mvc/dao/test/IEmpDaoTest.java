package com.company.mvc.dao.test;

import org.junit.Before;
import org.junit.Test;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;

public class IEmpDaoTest {

	private IEmpDao EmpDao;

	@Before
	public void setUp() throws Exception {
		EmpDao = DaoFactory.getEmpInstance();
	}

	@Test
	public void testFindByName() throws Exception {
		Emp t = new Emp(8999,"aa","aaa",1111,"2020-02-02",20,20,20);
//		t.setEmpno(9999,"ss","aaa",1111,"2020-02-02",20,20,20);
		EmpDao.delete(t);
		System.out.println("11");
	}

}
