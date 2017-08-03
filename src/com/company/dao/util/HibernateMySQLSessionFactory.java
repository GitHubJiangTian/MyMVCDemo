package com.company.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateMySQLSessionFactory {
	private static Configuration configuration;
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	static {
		configuration = new Configuration().configure("hibernate.cfg.xml");
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Configuration getConfiguration() {
		return configuration;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void rebuildSessionFactory() {
		//因为可能根据配置文件创建对象异常，所以要放在try块内
		try {
			configuration = new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		Session session = threadLocal.get();
		if(session == null) {
			if(sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = sessionFactory != null ? sessionFactory.openSession() : null;
			threadLocal.set(session);
		}
		return session;
	}
	
	public static void close() {
		Session session = threadLocal.get();
		if(session != null) {
			threadLocal.set(null);
			session.close();
		}
	}
}
