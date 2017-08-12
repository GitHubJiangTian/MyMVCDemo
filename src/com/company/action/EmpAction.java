package com.company.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.company.dao.pojo.Emp;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IEmpService;
import com.opensymphony.xwork2.ModelDriven;

public class EmpAction implements ModelDriven<Emp>, SessionAware {

	// 连接到service
	private IEmpService EmpService;
	private Map<String, Object> sessionMap;
	private Emp emp = new Emp();
	private String option;

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	@Override
	public Emp getModel() {
		return emp;
	}

	// 构造方法
	public EmpAction() {
		EmpService = ServiceFactory.getEmpInstance();
	}

	// 连接service层
	public IEmpService getEmpService() {
		return EmpService;
	}

	public void setEmpService(IEmpService empService) {
		EmpService = empService;
	}

	// option的getset方法
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	// 核心业务
	public String save() {
		return EmpService.save(emp);
	}

	public String update() {
		return EmpService.update(emp);
	}

	public String delete() {
		return EmpService.delete(emp);
	}

	public String findAll() {
		String msg = "error";
		List<Emp> EmpList = EmpService.findAll();
		if (EmpList != null && EmpList.size() > 0) {
			ServletActionContext.getRequest().setAttribute("EmpList", EmpList);
			msg = "success";
		} else {
			sessionMap.put("errMsg", "没有任何员工");
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Emp p = EmpService.findById(emp.getEmpno());
		List<Emp> EmpList = new ArrayList<Emp>();
		if (p != null) {
			if ("update".equals(option)) {
				ServletActionContext.getRequest().setAttribute("Emp", p);
				msg = "updatesuccess";
			} else {
				EmpList.add(p);
				ServletActionContext.getRequest().setAttribute("EmpList", EmpList);
				msg = "success";
			}
		} else {
			sessionMap.put("errMsg", "未找到该员工");
		}
		return msg;
	}

	public String findByName() {
		String msg = "error";
		List<Emp> EmpList = EmpService.findByName(emp.getEname());
		if (EmpList != null && EmpList.size() > 0) {
			ServletActionContext.getRequest().setAttribute("EmpList", EmpList);
			msg = "success";
		} else {
			sessionMap.put("errMsg", "未找到该员工");
		}
		return msg;
	}

}
