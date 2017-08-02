package com.company.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.company.dao.pojo.Product;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IProductService;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction implements ModelDriven<Product> {

	/*
	 * 没有使用ModelDriven的写法
	// 将product所有pojo类属性复制过来，struts2会自动取值
	private int pid;// 自增主键
	private String pname;// 商品名
	private String ean;// 商品的国际商品编号
	private double price;// 商品价格
	 */	
	
	//ModelDriven写法
	private Product product = new Product();
	
	@Override
	public Product getModel() {
		return product;
	}
	
	private String option;

	// 设置属性的set get方法
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	/*
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	*/

	// 连接到service
	private IProductService productService;

	public ProductAction() {
		productService = ServiceFactory.getProductInstance();
	}

	// 核心业务
	public String save() {
		//Product p = new Product(pname, ean, price);
		return productService.save(product);
	}

	public String update() {
//		Product p = new Product(pname, ean, price);
//		p.setPid(pid);
		return productService.update(product);
	}

	public String delete() {
//		Product p = new Product();
//		p.setPid(pid);
		return productService.delete(product);
	}

	public String findAll() {
		String msg = "error";
		List<Product> productList = productService.findAll();
		if (productList != null && productList.size() > 0) {
			ServletActionContext.getRequest().setAttribute("productList", productList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Product p = productService.findById(product.getPid());
		List<Product> productList = new ArrayList<Product>();
		if (p != null) {
			if("update".equals(option)) {
				ServletActionContext.getRequest().setAttribute("product", p);
				msg = "updatesuccess";
			}else {
				productList.add(p);
				ServletActionContext.getRequest().setAttribute("productList", productList);
				msg = "success";
			}
		}
		return msg;
	}

	public String findByName() {
		String msg = "error";
		List<Product> productList = productService.findByName(product.getPname());
		if (productList != null && productList.size() > 0) {
			ServletActionContext.getRequest().setAttribute("productList", productList);
			msg = "success";
		}
		return msg;
	}


}
