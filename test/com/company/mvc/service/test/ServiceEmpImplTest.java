package com.company.mvc.service.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.company.dao.pojo.Emp;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IEmpService;

public class ServiceEmpImplTest {

	IEmpService EmpService;

	@Before
	public void setUp() throws Exception {
		EmpService = ServiceFactory.getEmpInstance();
	}

	@Test
	public void testSave() {
		Emp t = new Emp(8999,"aa","aaa",1111, new Date(),20,20,20);
		EmpService.save(t);
		System.out.println("11");
	}
	@Test
	public void findAll() {
		List<Emp> list = EmpService.findAll();
		for(Emp e : list) {
			System.out.println(e);
		}
		System.out.println("11");
	}

	@Test
	public void testUpdate() {
//		Emp t = new Emp(8999,"sa","aaa",1111,"2020-02-02",20,20,20);
//		EmpService.update(t);
//		System.out.println("11");	
		}

	@Test
	public void testDelete() {
		Emp t = new Emp();
		t.setEmpno(7777);
		Emp t1 = new Emp();
		t1.setEmpno(1222);
		EmpService.delete(t1);
		System.out.println("end>>>>>>>>>>>>>>>>>>>>>>>");
		EmpService.delete(t);
		System.out.println("end>>>>>>>>>>>>>>>>>>>>>>>");
	}

}
