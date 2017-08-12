package com.company.mvc.dao.test;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;

public class Hibernate_ORM_Login_Detail_Test {

	Configuration configuration = null;
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction trans = null;
	
	@Before
	public void setUp() throws Exception {
		configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		trans = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		trans.commit();
		session.close();
		sessionFactory.close();
	}

	@Test	
	public void initTest() {
		System.out.println("1");
	}
	
	@Test
	public void saveTest() {
		Login u1 = new Login("aaa","aaa");
		Login u2 = new Login("aaa1","aaa1");
		Login u3 = new Login("aaa2","aaa2");		
		Detail d1 = new Detail("AAA",100.11);
		Detail d2 = new Detail("AAA2",100.22);
		Detail d3 = new Detail("AAA3",100.33);
		//ORM一对一不许互相设置！！！！不智能
		u1.setDetail(d1);
		d1.setLogin(u1);
		u2.setDetail(d2);
		d2.setLogin(u2);
		u3.setDetail(d3);
		d3.setLogin(u3);
		session.save(u1);
		session.save(d1);
		session.save(u2);
		session.save(d2);
		session.save(u3);
		session.save(d3);
	}

	@Test	
	public void deteleTest() {
		//删除必须先删除依赖方。
		session.delete(session.get(Detail.class, 2));
		session.delete(session.get(Login.class, 2));
	}

	@Test	
	public void updateTest() {
		Detail d = (Detail) session.get(Detail.class, 3);
		d.setRealname("bbbbb");
	}
}
