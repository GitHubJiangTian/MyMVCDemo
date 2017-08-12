package com.company.dao.pojo;

import java.io.Serializable;
/**
 * 
 * @author wpjt1
 * Detail对应t_detail表
 */
public class Detail implements Serializable{
	//每次更改本实体类要更改次版本号，用以区分是否要更新客户端
	private static final long serialVersionUID = 1L;
	
	private int userid;//自增主键
	private String realname;//用户真实姓名
	private Double balance;//用户余额
	private Login login;//Hibernate 一对一ORM需要添加（与login对应）
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Detail(String realname, Double balance) {
		super();
		this.realname = realname;
		this.balance = balance;
	}
	public Detail() {
		super();
	}
	@Override
	public String toString() {
		return "Detail [userid=" + userid + ", realname=" + realname + ", balance=" + balance + "]";
	}
	
}
