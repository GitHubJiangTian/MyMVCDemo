package com.company.mvc.springtest;

//DataSource导包不能错！！！！！
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSessionFactory {
	
	ApplicationContext ctx;
	
	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void test() {
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		System.out.println(dataSource);
	}
	
	@Test
	public void test1() {
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		System.out.println("sessionFactory:  "+sessionFactory);
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("session: "+session);
	}
}
