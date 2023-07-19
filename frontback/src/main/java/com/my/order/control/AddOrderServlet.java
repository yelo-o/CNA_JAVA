package com.my.order.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.AddException;
import com.my.order.dto.OrderInfo;
import com.my.order.dto.OrderLine;
import com.my.order.service.OrderService;
@WebServlet("/addorder")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service;
	public AddOrderServlet() {
		//service = new OrderService();
		service = OrderService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginedId = (String)session.getAttribute("loginedId");
		Map<String, Integer>cart = (Map<String, Integer>)session.getAttribute("cart");
		if(loginedId == null) {
			request.setAttribute("msg", "로그인하세요");
		}else if(cart == null || cart.size() ==0){
			request.setAttribute("msg", "장바구니가 비었습니다");
		}else {
			try {
//				service.add(info);
				service.add(loginedId, cart);
				request.setAttribute("status", 1);
				
				//장바구니 비우기
				session.removeAttribute("cart");
			} catch (AddException e) {
				request.setAttribute("status", 0);
			}
		}
		String path = "/jsp/addorderresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}
