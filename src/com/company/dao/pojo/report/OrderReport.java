package com.company.dao.pojo.report;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Item;
import com.company.dao.pojo.Login;
import com.company.dao.pojo.Orders;
import com.company.dao.pojo.Product;
/**
 * 
 * @author wpjt1
 * 报表的pojo类，此类中有所有可能用到的报表信息
 */
public class OrderReport {
	private Login login;//登陆名，密码
	private Detail detail;//用户真实姓名，余额
	private Orders orders;//订单编号，订单创建时间
	private Item item;//商品数量
	private Product product;//商品名，商品编号，商品价格

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderReport [login=" + login + ", detail=" + detail + ", orders=" + orders + ", item=" + item
				+ ", product=" + product + "]";
	}

	public OrderReport(Login login, Detail detail, Orders orders, Item item, Product product) {
		super();
		this.login = login;
		this.detail = detail;
		this.orders = orders;
		this.item = item;
		this.product = product;
	}

	public OrderReport() {
		super();
	}

}
