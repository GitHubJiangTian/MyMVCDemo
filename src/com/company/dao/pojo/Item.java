package com.company.dao.pojo;

import java.io.Serializable;
/**
 * 
 * @author wpjt1
 * Item对应t_item表，此表是商品表和订单表多对多的中间表
 */
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	private int itemid;//自增主键
	private int oid;//订单编号，外键关联t_order的oid主键
	private int pid;//商品编号，外键关联t_product的pid主键
	private int pnum;//所购买的商品数量

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", oid=" + oid + ", pid=" + pid + ", pnum=" + pnum + "]";
	}

	public Item(int oid, int pid, int pnum) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.pnum = pnum;
	}

}
