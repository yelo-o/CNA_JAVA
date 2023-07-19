package com.my.order.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.FindException;
import com.my.order.dto.OrderInfo;
import com.my.order.service.OrderService;

@WebServlet("/orderlist")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service;
	public OrderListServlet() {
		//service = new OrderService();
		service = OrderService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginedId = (String)session.getAttribute("loginedId");
		if(loginedId == null) {
			request.setAttribute("msg", "로그인하세요");
		}else {
			List<OrderInfo> list;
			try {
				list = service.findById(loginedId);
				request.setAttribute("list", list);
			} catch (FindException e) {
				e.printStackTrace();
				request.setAttribute("msg", e.getMessage());
			}
		}
		String path = "/jsp/orderlistresult.jsp";
		RequestDispatcher rd  = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}
}
