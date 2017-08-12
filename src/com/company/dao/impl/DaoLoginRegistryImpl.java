package com.company.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.ILoginRegistryDao;
import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;


@Repository("loginregistryDao")
public class DaoLoginRegistryImpl implements ILoginRegistryDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void registry(Login login, Detail detail) throws Exception {
		Session session = sessionFactory.getCurrentSession();
//		Transaction trans = session.beginTransaction();
		session.save(login);
		session.save(detail);
//		trans.commit();
	}

	@Override
	public Login login(Login login) throws Exception {
		Session session = sessionFactory.getCurrentSession();
//		Transaction trans = session.beginTransaction();
		Login result = null;
		result = (Login) session.createQuery("from Login where username=:username and userpwd=:userpwd")
				.setParameter("username", login.getUsername()).setParameter("userpwd", login.getUserpwd())
				.uniqueResult();
//		trans.commit();
		return result;
	}

}
