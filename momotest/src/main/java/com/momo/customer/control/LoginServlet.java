package com.momo.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.customer.dto.Customer;
import com.momo.customer.service.CustomerService;
import com.momo.exception.FindException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public LoginServlet() {
		service = CustomerService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//get session
		HttpSession session = request.getSession();
		session.removeAttribute("loginedId"); //clear
		int status = 0;
		try {
			Customer c = service.login(id,pwd);
			status = 1;
			session.setAttribute("loginedId", id);
		} catch(FindException e) {
			e.printStackTrace();
		}
		
		String path = "/jsp/loginresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status", status);
		rd.forward(request, response);
	}
}
