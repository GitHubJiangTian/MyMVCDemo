package com.company.dao.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author wpjt1
 * order对应t_order表
 */
public class Orders implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int oid;//自增主键
	private String orderNum;//商品编号
	private String data;//订单创建时间
	private int userid;//外键关联User信息--Login的id

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", orderNum=" + orderNum + ", data=" + data + ", userid=" + userid + "]";
	}

	public Orders(String orderNum, String data, int userid) {
		super();
		this.orderNum = orderNum;
		this.data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		this.userid = userid;
	}
	
}
