package com.my.order.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.FindException;
import com.my.product.dto.Product;
import com.my.product.service.ProductService;

@WebServlet("/cartlist")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	public CartListServlet() {
		service = new ProductService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  =  request.getSession();
		Map<String, Integer> cart = (Map)session.getAttribute("cart");
		if(cart == null) {
			request.setAttribute("msg", "장바구니가 비었습니다");
		}else {
			Map<Product, Integer> resultCart = new HashMap<>();
			for(String prodNo: cart.keySet()) {
				try {
					Product p = service.findByProdNo(prodNo);
					resultCart.put(p, cart.get(prodNo));
				} catch (FindException e) {
//					e.printStackTrace();
				}
			}
			request.setAttribute("resultcart", resultCart);
		}
		String path = "/jsp/cartlistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
