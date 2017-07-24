package com.company.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.pojo.Product;
import com.company.service.factory.ServiceFactory;


@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		String ean = request.getParameter("ean");
		double price = Double.parseDouble(request.getParameter("price"));
		Product p = new Product(pname,ean,price);
		p.setPid(pid);
		
		String Msg = ServiceFactory.getProductInstance().update(p);
		if("success".equals(Msg)) {
			response.sendRedirect(request.getContextPath()+"/ProductFindAllServlet");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "修改失败");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
