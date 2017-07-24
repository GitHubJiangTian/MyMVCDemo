package com.company.mvc.service.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.dao.pojo.Product;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IProductService;

public class ServiceProductImplTest {

	IProductService productService;

	
	@Before
	public void setUp() throws Exception {
		productService = ServiceFactory.getProductInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		Product p = new Product("FFF","fff",123.45);
		p.setPid(11);
		String msg = productService.save(p);
		System.out.println("success".equals(msg)?"save success！":"save error!");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

}
