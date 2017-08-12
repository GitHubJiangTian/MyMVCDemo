package com.company.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;

import com.company.dao.util.HibernateOracleSessionFactory;

public class DaoEmpImpl implements IEmpDao {

	@Override
	public void save(Emp t) throws Exception {
		Session session = HibernateOracleSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		HibernateOracleSessionFactory.close();
	}

	@Override
	public void update(Emp t) throws Exception {
		Session session = HibernateOracleSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		HibernateOracleSessionFactory.close();
	}

	@Override
	public void delete(Emp t) throws Exception {
		Session session = HibernateOracleSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.delete(t);
		trans.commit();
		HibernateOracleSessionFactory.close();
	}

	@Override
	public List<Emp> findAll() throws Exception {
		Session session = HibernateOracleSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<Emp> empList = null;
		empList = session.createQuery("from Emp").list();
		trans.commit();
		HibernateOracleSessionFactory.close();
		return empList;
	}

	@Override
	public Emp findById(Integer k) throws Exception {
		Session session = HibernateOracleSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		Emp e = null;
		// 因为是正向工程，所以“from Product”中的Product不是数据库中的表名为Product表，而是自己pojo对应的实体累的名字
		e = (Emp) session.createQuery("from Emp where empno=:empno").setParameter("empno", k).uniqueResult();
		trans.commit();
		HibernateOracleSessionFactory.close();
		return e;
	}

	@Override
	public List<Emp> findByName(String ename) throws Exception {
		Session session = HibernateOracleSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<Emp> empList = null;
		// 因为是正向工程，所以“from Product”中的Product不是数据库中的表名为Product表，而是自己pojo对应的实体累的名字
		empList = session.createQuery("from Emp where ename like :ename").setParameter("ename", "%" + ename + "%")
				.list();
		trans.commit();
		HibernateOracleSessionFactory.close();
		return empList;
	}

	@Override
	public List<Emp> findByPage(int page, int size) throws Exception {
		Session session = HibernateOracleSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<Emp> empList = null;
		// 因为是正向工程，所以“from Product”中的Product不是数据库中的表名为Product表，而是自己pojo对应的实体累的名字
		empList = session.createQuery("from Emp").setFirstResult((page - 1) * size).setMaxResults(size).list();
		trans.commit();
		HibernateOracleSessionFactory.close();
		return empList;
	}

}
