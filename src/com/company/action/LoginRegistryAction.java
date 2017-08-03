package com.company.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.ILoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginRegistryAction extends ActionSupport implements SessionAware{
	
	
	private static final long serialVersionUID = 1L;
	
	private ILoginService loginService;

	public LoginRegistryAction() {
		loginService = ServiceFactory.getLoginInstance();
	}
	
	private Map<String, Object> session = new HashMap<String, Object>() ;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	private String username;//登录名
	private String userpwd;//密码
	private String realname;//用户真实姓名
	private Double balance;//用户余额

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
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
	
	public String login() {
		String msg = loginService.login(new Login(username,userpwd));
		if("success".equals(msg)){
			session.put("username", username);
		}
		return msg;
	}

	public String registry() {
		Login login = new Login(username,userpwd);
		Detail detail = new Detail(realname,balance);
		String msg = loginService.registry(login, detail);
		return msg;
	}
}
