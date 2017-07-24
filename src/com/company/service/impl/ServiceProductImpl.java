package com.company.service.impl;

import java.util.List;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IProductDao;
import com.company.dao.pojo.Product;
import com.company.service.iservice.IProductService;

/**
 * 
 * @author wpjt1 接口IProductService的实现类
 */
public class ServiceProductImpl implements IProductService {

	private IProductDao productDao;

	public ServiceProductImpl() {
		productDao = DaoFactory.getProductInstance();
	}

	@Override
	public String save(Product t) {
		String msg = "error";
		try {
			Product p = productDao.findById(t.getPid());
			if (p == null) {
				productDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String update(Product t) {
		String msg = "error";
		try {
			Product p = productDao.findById(t.getPid());
			if (p != null) {
				productDao.update(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String delete(Product t) {
		String msg = "error";
		try {
			Product p = productDao.findById(t.getPid());
			if (p != null) {
				productDao.delete(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Product> findAll() {
		List<Product> productList = null;
		try {
			productList = productDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public Product findById(Integer k) {
		Product p = null;
		try {
			p = productDao.findById(k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> findByName(String pname) {
		List<Product> productList = null;
		try {
			productList = productDao.findByName(pname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

}
