package com.company.service.iservice;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
/**
 * 
 * @author wpjt1
 * 登陆功能的service接口
 */
public interface ILoginService extends IBasicService<Login,Integer> {
	/**
	 * 用户注册
	 * @param login 登陆帐号密码表pojo
	 * @param detail 用户详细信息表
	 * @return String
	 */
	String registry(Login login,Detail detail);
	/**
	 * 登陆验证
	 * @param login 登陆帐号密码表pojo
	 * @return String
	 */
	String login(Login login);
	
}
