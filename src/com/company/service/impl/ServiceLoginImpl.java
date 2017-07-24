package com.company.service.impl;

import java.util.List;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.ILoginRegistryDao;
import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.service.iservice.ILoginService;


/**
 * 
 * @author wpjt1
 * 接口ILoginService的实现类
 */
public class ServiceLoginImpl implements ILoginService {

	private ILoginRegistryDao loginRegistryDao;
	
	public ServiceLoginImpl() {
		loginRegistryDao = DaoFactory.getLoginRegistryInstance();
	}
	
	@Override
	public String save(Login t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Login t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Login t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Login> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login findById(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registry(Login login, Detail detail) {
		String msg = "error";
		try {
			loginRegistryDao.registry(login, detail);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String login(Login login) {
		String msg = "error";
		Login result = null;
		try {
			result = loginRegistryDao.login(login);
			if(result != null) {
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
