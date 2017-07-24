package com.company.dao.pojo;

import java.io.Serializable;
/**
 * 
 * @author wpjt1
 * Login 对应t_login表，封装登陆信息。
 */
public class Login implements Serializable{
	
	//每次更改本实体类要更改次版本号，用以区分是否要更新客户端
	private static final long serialVersionUID = 1L;
	
	private int userid;//自增主键
	private String username;//登录名
	private String userpwd;//密码
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
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
	public Login(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}
	public Login() {
		super();
	}
	
}
