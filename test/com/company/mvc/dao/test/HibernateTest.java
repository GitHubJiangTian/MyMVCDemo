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

import com.company.dao.pojo.Product;

public class HibernateTest {

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
	public void test() {
		Product p = (Product) session.get(Product.class, 1);
		System.out.println(p);
		Product p1 =(Product) session.get(Product.class, 2);
		System.out.println(p1);
		p.setPrice(22.22);
		p1.setPrice(22.22);
		session.evict(p1);
	}

}
