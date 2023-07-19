package com.my.product.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.FindException;
import com.my.product.service.ProductService;
import com.my.util.PageBean;

@WebServlet("/productlist")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	public ProductListServlet() {
		//service = new ProductService();
		service = ProductService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		String cp = request.getParameter("cp");
		if(cp != null && !cp.equals("")) {
			currentPage = Integer.parseInt(cp);
		}
		try {
//			List<Product> list = service.findAll(currentPage);
//			request.setAttribute("list", list);
			PageBean pb = service.findAll(currentPage);
			request.setAttribute("pagebean", pb);
		} catch (FindException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		String path = "/jsp/productlistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
