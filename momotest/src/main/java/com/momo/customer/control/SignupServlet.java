package com.momo.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.customer.dto.Customer;
import com.momo.customer.service.CustomerService;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public SignupServlet() {
		//service = new CustomerService();
		service = CustomerService.getInstance();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		int status = 0;
		try {
			status = 1;
			Customer c = new Customer(id,name,pwd);
			service.signup(c);
		} catch(AddException | FindException e) {
			e.printStackTrace();
		}
		String path = "/jsp/loginresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status", status);
		rd.forward(request, response);
	}

}
