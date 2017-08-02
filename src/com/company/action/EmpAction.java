package com.company.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.company.dao.pojo.Emp;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IEmpService;
import com.opensymphony.xwork2.ModelDriven;

public class EmpAction implements ModelDriven<Emp>{

	private Emp emp = new Emp();
	
	@Override
	public Emp getModel() {
		return emp;
	}
	
	private String option;

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}


	public IEmpService getEmpService() {
		return EmpService;
	}

	public void setEmpService(IEmpService EmpService) {
		this.EmpService = EmpService;
	}

	// 连接到service
	private IEmpService EmpService;

	public EmpAction() {
		EmpService = ServiceFactory.getEmpInstance();
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
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Emp p = EmpService.findById(emp.getEmpno());
		List<Emp> EmpList = new ArrayList<Emp>();
		if (p != null) {
			if("update".equals(option)) {
				ServletActionContext.getRequest().setAttribute("Emp", p);
				msg = "updatesuccess";
			}else {
				EmpList.add(p);
				ServletActionContext.getRequest().setAttribute("EmpList", EmpList);
				msg = "success";
			}
		}
		return msg;
	}

	public String findByName() {
		String msg = "error";
		List<Emp> EmpList = EmpService.findByName(emp.getEname());
		if (EmpList != null && EmpList.size() > 0) {
			ServletActionContext.getRequest().setAttribute("EmpList", EmpList);
			msg = "success";
		}
		return msg;
	}


}
