package com.company.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.dao.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author wpjt1
 * 实现了SessionAware接口，可以得到HttprequestSession(RequestAware同理，底层都是Map集合)
 */
public class IsLoginAction extends ActionSupport implements ModelDriven<User>,SessionAware {
	
	
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	//用来接收session
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	@Override
	public String execute(){
		if("aaa".equals(user.getUsername())){
			session.put("username", user.getUsername());
			return SUCCESS;
		}
		return ERROR;
	}
}
