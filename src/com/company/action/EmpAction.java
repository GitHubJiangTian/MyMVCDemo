package com.company.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.company.dao.pojo.Emp;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IEmpService;

public class EmpAction {

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private double sal;
	private double comm;
	private int deptno;
	private String option;

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
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
		Emp p = new Emp(empno, ename, job,mgr,hiredate,sal,comm,deptno);
		return EmpService.save(p);
	}

	public String update() {
		Emp p = new Emp(empno, ename, job,mgr,hiredate,sal,comm,deptno);
		return EmpService.update(p);
	}

	public String delete() {
		Emp p = new Emp();
		p.setEmpno(empno);
		return EmpService.delete(p);
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
		Emp p = EmpService.findById(empno);
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
		List<Emp> EmpList = EmpService.findByName(ename);
		if (EmpList != null && EmpList.size() > 0) {
			ServletActionContext.getRequest().setAttribute("EmpList", EmpList);
			msg = "success";
		}
		return msg;
	}
}
