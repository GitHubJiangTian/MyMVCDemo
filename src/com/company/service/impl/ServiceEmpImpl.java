package com.company.service.impl;

import java.util.List;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;
import com.company.service.iservice.IEmpService;

/**
 * 
 * @author wpjt1 接口IEmpService的实现类
 */
public class ServiceEmpImpl implements IEmpService {

	private IEmpDao EmpDao;

	public ServiceEmpImpl() {
		EmpDao = DaoFactory.getEmpInstance();
	}

	@Override
	public String save(Emp t) {
		String msg = "error";
		try {
			Emp p = EmpDao.findById(t.getEmpno());
			if (p == null) {
				EmpDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String update(Emp t) {
		String msg = "error";
		try {
			Emp p = EmpDao.findById(t.getEmpno());
			if (p != null) {
				EmpDao.update(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String delete(Emp t) {
		String msg = "error";
		try {
			Emp p = EmpDao.findById(t.getEmpno());
			if (p != null) {
				EmpDao.delete(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Emp> findAll() {
		List<Emp> EmpList = null;
		try {
			EmpList = EmpDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EmpList;
	}

	@Override
	public Emp findById(Integer k) {
		Emp p = null;
		try {
			p = EmpDao.findById(k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Emp> findByName(String ename) {
		List<Emp> EmpList = null;
		try {
			EmpList = EmpDao.findByName(ename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EmpList;
	}

}
