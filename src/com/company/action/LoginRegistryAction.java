package com.company.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.service.iservice.ILoginService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("loginregistryAction")
@Scope("prototype")
public class LoginRegistryAction extends ActionSupport implements SessionAware{
	
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;

	public LoginRegistryAction() {
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
		login.setDetail(detail);
		detail.setLogin(login);
		String msg = loginService.registry(login, detail);
		return msg;
	}
}
