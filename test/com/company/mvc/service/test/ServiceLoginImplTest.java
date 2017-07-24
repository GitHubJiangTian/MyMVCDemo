package com.company.mvc.service.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.ILoginService;

public class ServiceLoginImplTest {
	ILoginService loginService;

	@Before
	public void setUp() throws Exception {
		loginService = ServiceFactory.getLoginInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegistry() {
		Login login = new Login("scott1","tiger1");
		Detail detail = new Detail("qq",23.45);
		System.out.println(loginService.registry(login, detail));
	}

	@Test
	public void testLogin() {
		Login login = new Login("scott","tiger");
		System.out.println(loginService.login(login));
	}

}
