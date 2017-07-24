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


@WebServlet("/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		Product p = new Product();
		p.setPid(pid);
		String Msg = ServiceFactory.getProductInstance().delete(p);
		if("success".equals(Msg)) {
			response.sendRedirect(request.getContextPath()+"/ProductFindAllServlet");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "无法删除！");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
