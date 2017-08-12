package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.ILoginRegistryDao;
import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.service.iservice.ILoginService;


/**
 * 
 * @author wpjt1
 * 接口ILoginService的实现类
 */
@Service("loginService")
public class ServiceLoginImpl implements ILoginService {

	
	@Autowired
	@Qualifier("loginregistryDao")
	private ILoginRegistryDao loginRegistryDao;
	
	public ServiceLoginImpl() {
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
	@Transactional
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

	@Transactional
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
