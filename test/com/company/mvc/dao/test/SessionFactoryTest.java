package com.company.mvc.dao.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.dao.util.SessionFactory;


public class SessionFactoryTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Test Begin...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test End...");
	}

	@Test
	public void testGetConnection() throws Exception {
		System.out.println(SessionFactory.getInstance().getSession().toString());
	}

}
