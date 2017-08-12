package com.company.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.dao.pojo.Product;
import com.company.service.iservice.IProductService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("productAction")
@Scope("prototype")
public class ProductAction implements ModelDriven<Product> {

	// ModelDriven写法
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

	// 连接到service
	@Autowired
	@Qualifier("productService")
	private IProductService productService;

	public ProductAction() {
	}

	// 核心业务
	public String save() {
		return productService.save(product);
	}

	public String update() {
		return productService.update(product);
	}

	public String delete() {
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
			if ("update".equals(option)) {
				ServletActionContext.getRequest().setAttribute("product", p);
				msg = "updatesuccess";
			} else {
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
