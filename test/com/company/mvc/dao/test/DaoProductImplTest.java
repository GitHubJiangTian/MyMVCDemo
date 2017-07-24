package com.company.mvc.dao.test;



import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IProductDao;
import com.company.dao.pojo.Product;

public class DaoProductImplTest {

	private IProductDao productDao;
	
	@Before
	public void setUp() throws Exception {
		productDao = DaoFactory.getProductInstance();
	}

	@Test
	public void testSave() throws Exception {
		Product p1 = new Product("AAAA","aaaa",15.00);
		Product p2 = new Product("BBBB","bbbb",40.00);
		Product p3 = new Product("CCCC","cccc",800.00);
		Product p4 = new Product("DDDD","dddd",4.50);
		productDao.save(p1);
		productDao.save(p2);
		productDao.save(p3);
		productDao.save(p4);
	}

	@Test
	public void testUpdate() throws Exception {
		Product p = new Product();
		p.setPid(1);
		p.setPname("LiuLian");
		p.setEan("a001");
		p.setPrice(150.00);
		productDao.update(p);
	}

	@Test
	public void testDelete() throws Exception {
		Product p = new Product();
		p.setPid(4);
		productDao.delete(p);
		System.out.println("delete success!");
	}

	@Test
	public void testFindAll() throws Exception {
		List<Product> productList = productDao.findAll();
		for(Product p:productList){
			System.out.println(p);
		}
	}

	@Test
	public void testFindById() throws Exception {
		System.out.println(productDao.findById(1));
	}

	@Test
	public void testFindByName() throws Exception {
		List<Product> productList = productDao.findByName("a");
		for(Product p:productList){
			System.out.println(p);
		}
	}

	@Test
	public void testFindByPageA() throws Exception {
		List<Product> productList = productDao.findByPage(1, 2);
		for(Product p:productList){
			System.out.println(p);
		}
	}
}
