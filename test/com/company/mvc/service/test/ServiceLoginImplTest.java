package com.company.mvc.service.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.ILoginService;

public class ServiceLoginImplTest {
	ILoginService loginService;

	@Before
	public void setUp() throws Exception {
		loginService = (ILoginService) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("loginService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegistry() {
		Login login = new Login("aaa","aaa");
		Detail detail = new Detail("qq",23.45);
		//hibernate的测试类必须这么写
		login.setDetail(detail);
		detail.setLogin(login);
		System.out.println(loginService.registry(login, detail));
	}

	@Test
	public void testLogin() {
		Login login = new Login("aaa","aaa");
		System.out.println(loginService.login(login));
	}

}
