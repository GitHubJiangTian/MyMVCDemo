package com.company.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.IProductDao;
import com.company.dao.pojo.Product;


@Repository("productDao")
public class DaoProductImpl implements IProductDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Product t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
//		Transaction trans = session.beginTransaction();
		session.save(t);
//		trans.commit();
	}

	@Override
	public void update(Product t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
//		Transaction trans = session.beginTransaction();
		session.update(t);
//		trans.commit();
	}

	@Override
	public void delete(Product t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
//		Transaction trans = session.beginTransaction();
		session.delete(t);
//		trans.commit();
	}

	@Override
	public List<Product> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
//		Transaction trans = session.beginTransaction();
		List<Product> productList = null;
		//因为是正向工程，所以“from Product”中的Product不是数据库中的表名为Product表，而是自己pojo对应的实体累的名字
		productList = session.createQuery("from Product").list();
//		trans.commit();
		return productList;
	}

	@Override
	public Product findById(Integer k) throws Exception {
		Session session = sessionFactory.openSession();
//		Transaction trans = session.beginTransaction();
		Product p = null;
		p = (Product) session.createQuery("from Product where pid=:pid").setParameter("pid",k).uniqueResult();
//		trans.commit();
		session.close();
		return p;
	}

	@Override
	public List<Product> findByName(String pname) throws Exception {
		Session session = sessionFactory.getCurrentSession();
//		Transaction trans = session.beginTransaction();
		List<Product> productList = null;
		productList = session.createQuery("from Product where pname like :pname").setParameter("pname", "%"+pname+"%").list();
//		trans.commit();
		return productList;
	}

	@Override
	public List<Product> findByPage(int page, int size) throws Exception {
		Session session = sessionFactory.getCurrentSession();
//		Transaction trans = session.beginTransaction();
		List<Product> productList = null;
		productList = session.createQuery("from Product").setFirstResult((page - 1) * size).setMaxResults(size).list();
//		trans.commit();
		return productList;
	}

}
